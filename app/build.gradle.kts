import deps.LibraryDependencies
import deps.LibraryDependencies.AndroidX
import deps.LibraryDependencies.DI
import deps.LibraryDependencies.View
import deps.Modules
import deps.TestLibraryDependency.AndroidTestImplementationLibrary
import deps.TestLibraryDependency.TestImplementationLibrary

plugins {
    projectAndroidApplication
    safeArgs
    daggerHilt
    googleServices
    crashlytics
}

android {
    buildFeatures.apply {
        dataBinding = true
        viewBinding = true
    }
    applicationVariants.all { variant ->
        variant.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                output.outputFileName = output.outputFileName
                    .replace("app-", "News-Feed")
                    .replace(".apk", "-${variant.versionName}.${variant.versionCode}.apk")

            }
        true
    }
}

dependencies {
    implementation(project(Modules.DATA))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.CACHE))

    implementAll(AndroidX.components)
    implementAll(View.components)
    implementAll(LibraryDependencies.Coroutines.components)
    implementAll(LibraryDependencies.Firebase.components)
    implementAll(LibraryDependencies.Cache.components)

    implementation(LibraryDependencies.Timber.TIMBER)

    implementation(DI.DAGGER_HILT_ANDROID)
    implementation(DI.HILT_WORK_MANAGER)

    implementation(LibraryDependencies.Google.GSON)
    implementation(LibraryDependencies.Google.FLEX_BOX)

    implementation(LibraryDependencies.Others.GLIDE)
    implementation(LibraryDependencies.Others.ANIMATION_LIBRARY)
    implementation(LibraryDependencies.Others.EASING_LIBRARY)
    implementation(LibraryDependencies.Others.JSOUP)

    implementation(LibraryDependencies.FlowBinding.ANDROID)
    implementation(LibraryDependencies.FlowBinding.LIFE_CYCLE)
    implementation(LibraryDependencies.FlowBinding.SWIPE_REFRESH)

    implementAll(LibraryDependencies.Network.components)

    kapt(DI.AnnotationProcessor.DAGGER_HILT_ANDROID)
    kapt(DI.AnnotationProcessor.HILT_VIEW_MODEL_COMPILER)
    kapt(DI.AnnotationProcessor.HILT_WORK_MANAGER)
    kapt(LibraryDependencies.Others.AnnotationProcessor.GLIDE)
    kapt(LibraryDependencies.Cache.AnnotationProcessor.ROOM)
    kapt(LibraryDependencies.Network.AnnotationProcessor.MOSHI)

    // Unit test
    testImplementation(TestImplementationLibrary.JUNIT)
    testImplementation(TestImplementationLibrary.LIFECYCLE)
    testImplementation(TestImplementationLibrary.MOCKITO_INLINE)
    testImplementation(TestImplementationLibrary.MOCKITO_KOTLIN)
    testImplementation(TestImplementationLibrary.COROUTINES_TEST)

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.android.support:customtabs:28.0.0")
    implementation("com.google.android.gms:play-services-location:18.0.0")
    implementation("com.github.marlonlom:timeago:4.0.3")

    // Integration test
    androidTestImplementation(AndroidTestImplementationLibrary.MOCKITO_KOTLIN)
    androidTestImplementation(AndroidTestImplementationLibrary.MOCKITO)
    androidTestImplementation(AndroidTestImplementationLibrary.LIFECYCLE)
    androidTestImplementation(AndroidTestImplementationLibrary.TEST_RUNNER)
    androidTestImplementation(AndroidTestImplementationLibrary.JUNIT_ANDROID)
    androidTestImplementation(AndroidTestImplementationLibrary.ESPRESSO_CORE)
    androidTestImplementation(AndroidTestImplementationLibrary.ESPRESSO_INTENT)
}
