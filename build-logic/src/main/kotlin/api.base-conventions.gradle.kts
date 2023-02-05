plugins {
    `java-library`
    id("net.kyori.indra")
}

indra {
    github("GeyserMC", "api") {
        ci(true)
    }
    mitLicense()

    javaVersions {
        target(8)
    }
}