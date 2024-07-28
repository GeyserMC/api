import java.net.URI

plugins {
    java
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
}

publishing {
    repositories {
        maven {
            name = "geysermc"
            url = URI.create(
                when {
                    project.version.toString().endsWith("-SNAPSHOT") ->
                        "https://repo.opencollab.dev/maven-snapshots"
                    else ->
                        "https://repo.opencollab.dev/maven-releases"
                }
            )
            credentials(PasswordCredentials::class.java)
        }
    }
}