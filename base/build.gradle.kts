plugins {
    idea
    alias(libs.plugins.blossom) apply true
}

dependencies {
    api(libs.checkerQual)
    api(libs.cumulus)
    api(libs.events) {
        exclude(group = "com.google.guava", module = "guava")
        exclude(group = "org.lanternpowered", module = "lmbda")
    }
}

version = property("baseApiVersion")!!
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
