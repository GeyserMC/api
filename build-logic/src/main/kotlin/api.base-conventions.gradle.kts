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
        target(8)
    }

    configurePublications {
        artifactId = "${project.name}-api"
        if (shouldAddBranchName()) {
            version = versionWithBranchName()
        }
    }

    publishSnapshotsTo("opencollab-artifactory", "https://repo.opencollab.dev/artifactory/maven-snapshots")
    publishReleasesTo("opencollab-artifactory", "https://repo.opencollab.dev/artifactory/maven-releases")
}