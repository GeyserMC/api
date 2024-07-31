plugins {
    idea
    alias(libs.plugins.blossom)
}

dependencies {
  api(libs.cumulus)
  api(libs.events)
  annotationProcessor(libs.events.ap)

  compileOnlyApi(libs.checker.qual)
}

val apiVersion = (version as String).removeSuffix("-SNAPSHOT")

sourceSets {
    main {
        blossom {
            javaSources {
                property("version", apiVersion)
            }
        }
    }
}
