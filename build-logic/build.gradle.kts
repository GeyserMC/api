import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("net.kyori", "indra-common", "3.0.1")
    implementation("net.kyori", "indra-git", "3.0.1")
    implementation("org.jfrog.buildinfo", "build-info-extractor-gradle", "4.26.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}