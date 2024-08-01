import java.net.URI

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
    if (shouldAddBranchName(version)) {
      version = versionWithBranchName()
    }
  }
}

spotless {
  java {
    palantirJavaFormat()
    formatAnnotations()
  }
  ratchetFrom("origin/master")
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