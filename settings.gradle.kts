plugins {
    id("com.gradleup.nmcp.settings") version "1.4.4"
}

rootProject.name = "clarity-protobuf"

nmcpSettings {
    centralPortal {
        username = providers.gradleProperty("mavenCentralUsername").get()
        password = providers.gradleProperty("mavenCentralPassword").get()
    }
}
