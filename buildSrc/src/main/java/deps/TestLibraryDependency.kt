package deps


object TestLibraryDependency {
    object Version {
        const val TEST_RUNNER = "1.3.0"
        const val MOCKITO = "3.6.28"
        const val MOCKITO_KOTLIN = "2.1.0"
        const val MOCKITO_INLINE = "3.5.10"
        const val LIFECYCLE = "2.1.0"

        const val JUNIT = "4.13.1"
        const val JUNIT_ANDROID = "1.1.2"
        const val ESPRESSO = "3.3.0"
        const val COROUTINES_TEST = "1.3.4"

        const val RUNNER: String = "1.1.0"
        const val RULES: String = "1.3.0"
        const val TEST_EXT: String = "1.1.1"
        const val FRAGMENT: String = "1.1.0-rc04"
        const val TRUTH: String = "1.0.1"
        const val MOCK_WEB_SERVER: String = "4.7.2"
        const val COROUTINE_TEST: String = "1.2.1"
    }


    // Unit Test
    object TestImplementationLibrary {
        const val JUNIT = "junit:junit:${Version.JUNIT}"
        const val LIFECYCLE =
            "androidx.arch.core:core-testing:${Version.LIFECYCLE}"
        const val MOCKITO_INLINE =
            "org.mockito:mockito-inline:${Version.MOCKITO_INLINE}"
        const val MOCKITO_KOTLIN =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.MOCKITO_KOTLIN}"
        const val COROUTINES_TEST =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINES_TEST}"


        const val RUNNER: String = "androidx.test:runner:${Version.RUNNER}"
        const val FRAGMENT_TESTING: String =
            "androidx.fragment:fragment-testing:${Version.FRAGMENT}"
        const val TEST_EXT: String = "androidx.test.ext:junit:${Version.TEST_EXT}"
        const val ESPRESSO: String = "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
        const val RULES: String = "androidx.test:rules:${Version.RULES}"
        const val TRUTH: String = "com.google.truth:truth:${Version.TRUTH}"
        const val MOCK_WEB_SERVER: String =
            "com.squareup.okhttp3:mockwebserver:${Version.MOCK_WEB_SERVER}"
        const val COROUTINE_TEST: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINE_TEST}"

    }

    // Integration test
    object AndroidTestImplementationLibrary {
        const val MOCKITO_KOTLIN =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.MOCKITO_KOTLIN}"
        const val MOCKITO = "org.mockito:mockito-android:${Version.MOCKITO}"
        const val LIFECYCLE =
            "androidx.arch.core:core-testing:${Version.LIFECYCLE}"
        const val JUNIT_ANDROID =
            "androidx.test.ext:junit:${Version.JUNIT_ANDROID}"
        const val TEST_RUNNER = "androidx.test:rules:${Version.TEST_RUNNER}"
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
        const val ESPRESSO_INTENT =
            "androidx.test.espresso:espresso-intents:${Version.ESPRESSO}"


        const val RUNNER: String = "androidx.test:runner:${Version.RUNNER}"
        const val FRAGMENT_TESTING: String =
            "androidx.fragment:fragment-testing:${Version.FRAGMENT}"
        const val TEST_EXT: String = "androidx.test.ext:junit:${Version.TEST_EXT}"
        const val ESPRESSO: String = "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
        const val RULES: String = "androidx.test:rules:${Version.RULES}"
        const val TRUTH: String = "com.google.truth:truth:${Version.TRUTH}"
        const val MOCK_WEB_SERVER: String =
            "com.squareup.okhttp3:mockwebserver:${Version.MOCK_WEB_SERVER}"
        const val COROUTINE_TEST: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINE_TEST}"
    }
}