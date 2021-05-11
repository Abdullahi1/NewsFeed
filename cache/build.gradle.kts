import deps.LibraryDependencies
import deps.TestLibraryDependency

plugins {
    projectAndroidLibrary
}

dependencies {

    implementation(project(deps.Modules.DATA))
    implementation(project(deps.Modules.DOMAIN))

    implementAll(LibraryDependencies.Cache.components)

    implementation(LibraryDependencies.Coroutines.CORE)
    implementation(LibraryDependencies.DI.DAGGER_HILT_ANDROID)


    kapt(LibraryDependencies.DI.AnnotationProcessor.DAGGER_HILT_ANDROID)
    kapt(LibraryDependencies.Cache.AnnotationProcessor.ROOM)

    testImplementation(TestLibraryDependency.TestImplementationLibrary.JUNIT)
    androidTestImplementation(TestLibraryDependency.AndroidTestImplementationLibrary.LIFECYCLE)
    androidTestImplementation(TestLibraryDependency.AndroidTestImplementationLibrary.TEST_RUNNER)
    androidTestImplementation(TestLibraryDependency.AndroidTestImplementationLibrary.JUNIT_ANDROID)
}
