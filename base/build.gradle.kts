dependencies {
  api(libs.checker.qual)
  api(libs.cumulus)
  api(libs.events)
  annotationProcessor(libs.events.ap)
}

version = property("baseApiVersion")!!