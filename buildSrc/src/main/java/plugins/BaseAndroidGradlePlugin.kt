package plugins

import deps.GradlePluginsConfig.KOTLIN_ANDROID
import deps.GradlePluginsConfig.KOTLIN_KAPT
import org.gradle.api.Plugin
import org.gradle.api.Project

open class BaseAndroidGradlePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configureKotlinAndroidPlugins()
    }
}

internal fun Project.configureKotlinAndroidPlugins() {
    plugins.apply(KOTLIN_ANDROID)
    plugins.apply(KOTLIN_KAPT)
}
