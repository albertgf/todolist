plugins {
    id("todolist.android.library")
    id("todolist.android.library.compose")
    id("todolist.android.koin")
}

android {
    namespace = "com.eirrok.todolist.core.testing"
}

dependencies {
    api(libs.androidx.compose.test)
    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.ext)
    api(libs.androidx.test.runner)
    api(libs.koin.test)
    api(libs.junit)
    api(libs.kotlinx.coroutines.test)

    debugApi(libs.androidx.compose.ui.manifest)

    //implementation(project(":core:common"))
    //implementation(project(":core:data"))
    //implementation(project(":core:domain"))
    //implementation(project(":core:model"))
    //implementation(project(":core:notifications"))
    //implementation(libs.kotlinx.datetime)
}