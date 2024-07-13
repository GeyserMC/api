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

sourceSets {
    main {
        blossom {
            javaSources {
                property("version", version as String)
            }
        }
    }
}