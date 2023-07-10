plugins {
  id("net.kyori.indra")
  id("net.kyori.indra.git")
  id("net.kyori.indra.publishing")
  id("net.kyori.indra.licenser.spotless")
}

indra {
  github("GeyserMC", "api") {
    ci(true)
    issues(true)
    scm(true)
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

  publishSnapshotsTo("geysermc", "https://repo.opencollab.dev/maven-snapshots")
  publishReleasesTo("geysermc", "https://repo.opencollab.dev/maven-releases")
}

spotless {
  java {
    palantirJavaFormat()
    formatAnnotations()
  }
  ratchetFrom("origin/master")
}