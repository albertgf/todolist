plugins {
    id("todolist.android.library")
    id("todolist.android.koin")
}

android {
    namespace = "com.eirrok.core.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(libs.kotlinx.coroutines.android)
}