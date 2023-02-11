plugins {
    id("api.build-logic")
}

allprojects {
    group = "org.geysermc.api"

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}

subprojects {
    apply(plugin = "api.base-conventions")
}