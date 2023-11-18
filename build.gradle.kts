plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
}

group = "com.skadistats"
version = "5.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
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

nexusPublishing {
    this.repositories {
        sonatype()
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}

