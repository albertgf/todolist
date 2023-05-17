import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidKoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {

            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "implementation"(libs.findLibrary("koin.core").get())
                "implementation"(libs.findLibrary("koin.android").get())
                "implementation"(libs.findLibrary("koin.androidx.compose").get())
                "implementation"(libs.findLibrary("koin.androidx.workmanager").get())
                "testImplementation"(libs.findLibrary("koin.test").get())
                "testImplementation"(libs.findLibrary("koin.test.junit4").get())
            }

        }
    }

}