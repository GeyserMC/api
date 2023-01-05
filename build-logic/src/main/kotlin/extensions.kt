import org.gradle.api.Project

fun Project.isSnapshot(): Boolean =
    version.toString().endsWith("-SNAPSHOT")