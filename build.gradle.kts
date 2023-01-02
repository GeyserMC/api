allprojects {
    group = "org.geysermc"
    version = "2.1.0-SNAPSHOT"
    description = "Allows for players from Minecraft: Bedrock Edition to join Minecraft: Java Edition servers."

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    apply {
        plugin("java-library")
    }
}

subprojects {
//    plugins.apply("geyser.api-conventions")
}