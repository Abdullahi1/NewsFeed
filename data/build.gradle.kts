import deps.LibraryDependencies
import deps.TestLibraryDependency.TestImplementationLibrary

plugins {
    projectAndroidLibrary
}

dependencies {
    implementation(project(deps.Modules.DOMAIN))

    implementAll(LibraryDependencies.Coroutines.components)
    implementAll(LibraryDependencies.Network.components)
    implementAll(LibraryDependencies.Firebase.components)

    implementation(LibraryDependencies.Timber.TIMBER)
    implementation(LibraryDependencies.DI.DAGGER_HILT_ANDROID)
    implementation(LibraryDependencies.DI.HILT_WORK_MANAGER)

    kapt(LibraryDependencies.Network.AnnotationProcessor.MOSHI)
    kapt(LibraryDependencies.DI.AnnotationProcessor.DAGGER_HILT_ANDROID)
    kapt(LibraryDependencies.DI.AnnotationProcessor.HILT_WORK_MANAGER)

    testImplementation(TestImplementationLibrary.MOCKITO_INLINE)
    testImplementation(TestImplementationLibrary.LIFECYCLE)
    testImplementation(TestImplementationLibrary.COROUTINES_TEST)
    testImplementation(TestImplementationLibrary.MOCKITO_KOTLIN)
    testImplementation(TestImplementationLibrary.MOCKITO_INLINE)

}
