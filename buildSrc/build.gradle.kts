plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    jcenter()
}

object Plugin {
    object Version {
        const val SPOTLESS = "4.0.1"
        const val GRADLE = "4.1.2"
        const val KOTLIN_GRADLE = "1.4.30"
        const val NAVIGATION = "2.3.0"
        const val DAGGER_HILT_ANDROID = "2.35.1"
    }

    const val SPOTLESS: String = "com.diffplug.spotless:spotless-plugin-gradle:${Version.SPOTLESS}"
    const val GRADLE = "com.android.tools.build:gradle:${Version.GRADLE}"
    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_GRADLE}"
    const val NAVIGATION_SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.NAVIGATION}"
    const val DAGGER_HILT: String =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.DAGGER_HILT_ANDROID}"
}

dependencies {
    implementation(Plugin.SPOTLESS)
    implementation(Plugin.GRADLE)
    implementation(Plugin.KOTLIN_GRADLE)
    implementation(Plugin.NAVIGATION_SAFE_ARGS)
    implementation(Plugin.DAGGER_HILT)
    /* Depend on the default Gradle API's since we want to build a custom plugin */
    implementation(gradleApi())
    implementation(localGroovy())
}
