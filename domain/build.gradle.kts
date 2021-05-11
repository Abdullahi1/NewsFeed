import deps.LibraryDependencies
import deps.TestLibraryDependency.TestImplementationLibrary

plugins {
    projectKotlinLibrary
}

dependencies {
    implementation(LibraryDependencies.Coroutines.CORE)
    implementation(LibraryDependencies.DI.JAVAX_INJECT)

    testImplementation(TestImplementationLibrary.JUNIT)
    testImplementation(TestImplementationLibrary.MOCKITO_INLINE)
    testImplementation(TestImplementationLibrary.MOCKITO_KOTLIN)
}
