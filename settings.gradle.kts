@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
  repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
  repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.opencollab.dev/main")
  }
}

pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

rootProject.name = "api-parent"

include(":base")