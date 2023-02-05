plugins {
    id("api.base-conventions")
    id("net.kyori.indra.git")
    id("com.jfrog.artifactory")
    id("maven-publish")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "$artifactId-api"
            from(components["java"])
        }
    }
}

// we need to execute this in afterEvaluate,
// because the version wouldn't have been set yet
// (used in isSnapshot as well)
afterEvaluate {
    if (shouldAddBranchName()) {
        publishing.publications {
            getByName<MavenPublication>("mavenJava") {
                version = versionWithBranchName()
            }
        }
    }

    artifactory {
        setContextUrl("https://repo.opencollab.dev/artifactory")
        publish {
            repository {
                setRepoKey(if (isSnapshot()) "maven-snapshots" else "maven-releases")
                setMavenCompatible(true)
            }
            defaults {
                publications("mavenJava")
                setPublishArtifacts(true)
                setPublishPom(true)
                setPublishIvy(false)
            }
        }
    }
}