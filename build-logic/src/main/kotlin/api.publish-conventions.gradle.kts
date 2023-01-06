plugins {
    id("api.base-conventions")
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

// without afterEvaluate isSnapshot would always return false
// because the version wouldn't have been set yet
afterEvaluate {
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