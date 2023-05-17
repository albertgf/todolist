plugins {
    id("todolist.android.library")
    id("todolist.android.library.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.eirrok.todolist.core.ui"
}

dependencies {
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.preview)
    api(libs.androidx.compose.ui.manifest)
    api(libs.androidx.navigation.compose)

    debugApi(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.core.ktx)
}