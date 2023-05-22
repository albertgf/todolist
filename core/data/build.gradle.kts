plugins {
    id("todolist.android.library")
    id("todolist.android.koin")
}

android {
    namespace = "com.eirrok.todolist.core.data"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }

    dependencies {
        implementation(project(":core:model"))
        implementation(project(":core:database"))
        implementation(libs.kotlinx.coroutines.android)

        testImplementation(project(":core:testing"))
    }
}

