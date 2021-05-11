package deps

import org.gradle.api.JavaVersion

object AndroidConfig {
    const val COMPILE_SDK_VERSION = 30
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 30
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val APPLICATION_ID = "com.example.newsfeed"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

object JavaConfig {
    val JAVA_VERSION = JavaVersion.VERSION_1_8
}

object GradlePluginsConfig {
    const val KOTLIN = "kotlin"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID_APPLICATION = "com.android.application"
}