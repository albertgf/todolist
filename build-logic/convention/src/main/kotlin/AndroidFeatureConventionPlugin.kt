import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("todolist.android.library")
                apply("todolist.android.koin")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        "com.eirrok.core.testing.ToDoListTestRunner"
                }
                //configureGradleManagedDevices(this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}