dependencies {
    api(projects.base)
}

version = property("geyserApiVersion")!!

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}