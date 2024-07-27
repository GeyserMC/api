plugins {
    `java-library`
    id("net.kyori.indra")
    id("net.kyori.indra.publishing")
    id("net.kyori.indra.git")
}

indra {
    github("GeyserMC", "api") {
        ci(true)
    }
    mitLicense()

    javaVersions {
        target(17)
    }

    configurePublications {
        artifactId = "${project.name}-api"
        if (shouldAddBranchName()) {
          version = versionWithBranchName()
        }
    }

    publishSnapshotsTo("geysermc", "https://repo.opencollab.dev/artifactory/maven-snapshots")
    publishReleasesTo("geysermc", "https://repo.opencollab.dev/artifactory/maven-releases")
}