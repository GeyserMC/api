dependencies {
  api(libs.cumulus)
  api(libs.events)
  annotationProcessor(libs.events.ap)

  compileOnlyApi(libs.checker.qual)
}

version = property("baseApiVersion")!!