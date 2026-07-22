plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
}

group = "com.skadistats"
version = "7.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
    withJavadocJar()
}

// TODO: this still does not suppress the messages, but seems to ignore errors on publishing
tasks.withType<Javadoc> {
    options {
        this as StandardJavadocDocletOptions
        addStringOption("Xdoclint:all,-missing")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    api("it.unimi.dsi:fastutil-core:8.5.12")
}

val verifyRuntimeRelocated by tasks.registering {
    group = "verification"
    description = "Fail if com.google.protobuf reappears in sources (vendored runtime must stay in skadistats.clarity.protobuf)."
    val srcDir = layout.projectDirectory.dir("src/main/java")
    inputs.dir(srcDir)
    val marker = layout.buildDirectory.file("verifyRuntimeRelocated.ok")
    outputs.file(marker)
    doLast {
        val needle = "com.google.protobuf"
        val offenders = srcDir.asFile.walkTopDown()
            .filter { it.isFile && it.extension == "java" && it.readText().contains(needle) }
            .map { it.relativeTo(projectDir).path }
            .toList()
        if (offenders.isNotEmpty()) {
            throw GradleException(
                "${offenders.size} file(s) still reference '$needle'. The vendored runtime lives in " +
                "skadistats.clarity.protobuf; re-run src/main/proto/make.sh after regenerating. " +
                "If a google/protobuf proto was compiled as a build target, vendor it into the runtime " +
                "rather than leaving it in com.google.protobuf.\n" +
                offenders.joinToString("\n").prependIndent("  ")
            )
        }
        marker.get().asFile.apply { parentFile.mkdirs(); writeText("ok") }
    }
}

tasks.named("check") { dependsOn(verifyRuntimeRelocated) }

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set(rootProject.name)
                description.set("Clarity is an open source replay parser for Dota 2 and CSGO 1 and 2 written in Java. This JAR contains the protobuf classes for clarity.")
                url.set("https://github.com/skadistats/clarity-protobuf")
                licenses {
                    license {
                        name.set("BSD style license")
                        url.set("https://github.com/skadistats/clarity-protobuf/blob/master/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("spheenik")
                        name.set("Martin Schrodt")
                        email.set("github@martin.schrodt.org")
                    }
                }
                scm {
                    connection.set("scm:git:git@github.com:skadistats/clarity-protobuf.git")
                    developerConnection.set("scm:git:git@github.com:skadistats/clarity-protobuf.git")
                    url.set("https://github.com/skadistats/clarity-protobuf")
                }
            }
        }
    }
}

signing {
    useGpgCmd()
    setRequired({
        gradle.taskGraph.allTasks.any { it.name.startsWith("publishAggregation") }
    })
    sign(publishing.publications["mavenJava"])
}

