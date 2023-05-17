plugins {
    id("todolist.android.library")
    id("todolist.android.koin")
}

android {
    namespace = "com.eirrok.core.domain"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}