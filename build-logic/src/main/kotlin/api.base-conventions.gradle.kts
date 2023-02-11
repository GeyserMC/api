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

    val repoUrl = "https://repo.opencollab.dev/artifactory"
    publishSnapshotsTo("maven-snapshots", repoUrl)
    publishReleasesTo("maven-releases", repoUrl)
}