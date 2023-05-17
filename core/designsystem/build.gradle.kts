plugins {
    id("todolist.android.library")
    id("todolist.android.library.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    lint {
        checkDependencies = true
    }
    namespace = "com.google.samples.apps.nowinandroid.core.designsystem"
}

dependencies {
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.preview)
    api(libs.androidx.compose.ui)

    debugApi(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.core.ktx)

    //androidTestImplementation(project(":core:testing"))
}