plugins {
    `java-library`
}

tasks.compileJava {
    options.encoding = Charsets.UTF_8.name()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withSourcesJar()
}