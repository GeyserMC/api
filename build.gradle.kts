plugins {
    id("api.build-logic")
}

allprojects {
    group = "org.geysermc.api"
}

subprojects {
    apply(plugin = "api.base-conventions")
}