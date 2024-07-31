plugins {
    idea
    alias(libs.plugins.blossom)
}

dependencies {
    api(libs.checker.qual)
    api(libs.cumulus)
    api(libs.events) {
        exclude(group = "com.google.guava", module = "guava")
        exclude(group = "org.lanternpowered", module = "lmbda")
    }
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
