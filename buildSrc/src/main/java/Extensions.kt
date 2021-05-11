import deps.GradlePluginsConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.initialization.dsl.ScriptHandler
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id(GradlePluginsConfig.ANDROID_APPLICATION)

val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = id(GradlePluginsConfig.ANDROID_LIBRARY)

val PluginDependenciesSpec.dynamicFeature: PluginDependencySpec
    get() = id("com.android.dynamic-feature")

val PluginDependenciesSpec.kotlin: PluginDependencySpec
    get() = id(GradlePluginsConfig.KOTLIN)

val PluginDependenciesSpec.daggerHilt: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")

val Project.applySpotless
    get() = apply(plugin = "spotless")

val PluginDependenciesSpec.kotlinLibrary: PluginDependencySpec
    get() = id("kotlin-library")

val PluginDependenciesSpec.safeArgs: PluginDependencySpec
    get() = id("androidx.navigation.safeargs.kotlin")

val PluginDependenciesSpec.projectKotlinLibrary: PluginDependencySpec
    get() = id("com.example.kotlin")

val PluginDependenciesSpec.projectAndroidApplication: PluginDependencySpec
    get() = id("com.example.android")

val PluginDependenciesSpec.projectAndroidLibrary: PluginDependencySpec
    get() = id("com.example.library")

val PluginDependenciesSpec.googleServices: PluginDependencySpec
    get() = id("com.google.gms.google-services")

val PluginDependenciesSpec.crashlytics: PluginDependencySpec
    get() = id("com.google.firebase.crashlytics")

fun RepositoryHandler.maven(url: String) {
    maven {
        setUrl(url)
    }
}

fun RepositoryHandler.applyDefault() {
    google()
    jcenter()
    mavenCentral()
}

fun DependencyHandler.implementAll(list: List<String>) {
    list.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addPlugins(list: List<String>) {
    list.forEach {
        add(ScriptHandler.CLASSPATH_CONFIGURATION, it)
    }
}

fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)
