@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://repo.opencollab.dev/main")
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        id("net.kyori.indra")
        id("net.kyori.indra.git")
    }
    includeBuild("build-logic")
}

rootProject.name = "api-parent"

include(":base", ":geyser")