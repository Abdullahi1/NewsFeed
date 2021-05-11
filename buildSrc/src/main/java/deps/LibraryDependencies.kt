package deps

const val ktLintVersion: String = "0.36.0"

interface Library {
    val components: List<String>
}

object LibraryDependencies {
    object AndroidX : Library {
        object Version {
            const val CORE_KTX = "1.3.2"
            const val APP_COMPAT = "1.2.0"
            const val NAVIGATION: String = "2.3.0"
            const val MULTI_DEX: String = "2.0.1"
            const val LIFE_CYCLE: String = "2.3.0-alpha03"
            const val ACTIVITY: String = "1.2.0-alpha05"
            const val LEGACY_SUPPORT = "1.0.0"
            const val WORK_MANAGER = "2.5.0"
        }

        // Support
        const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:${Version.LEGACY_SUPPORT}"
        const val APP_COMPAT =
            "androidx.appcompat:appcompat:${LibraryDependencies.AndroidX.Version.APP_COMPAT}"
        const val CORE_KTX: String = "androidx.core:core-ktx:${Version.CORE_KTX}"
        const val NAVIGATION_FRAGMENT_KTS: String =
            "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION}"
        const val NAVIGATION_UI_KTX: String =
            "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION}"
        const val NAVIGATION_DFM: String =
            "androidx.navigation:navigation-dynamic-features-fragment:${Version.NAVIGATION}"
        const val MULTI_DEX: String = "androidx.multidex:multidex:${Version.MULTI_DEX}"
        const val ACTIVITY: String = "androidx.activity:activity:${Version.ACTIVITY}"
        const val LIFE_CYCLE_COMMON: String =
            "androidx.lifecycle:lifecycle-common-java8:${Version.LIFE_CYCLE}"
        const val LIFE_CYCLE_VIEW_MODEL: String =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFE_CYCLE}"
        const val LIFE_CYCLE_LIVE_DATA =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFE_CYCLE}"
        const val WORK_MANAGER = "androidx.work:work-runtime-ktx:${Version.WORK_MANAGER}"


        override val components: List<String>
            get() = listOf(
                APP_COMPAT,
                CORE_KTX,
                NAVIGATION_FRAGMENT_KTS,
                NAVIGATION_UI_KTX,
                MULTI_DEX,
                ACTIVITY,
                LIFE_CYCLE_COMMON,
                LIFE_CYCLE_VIEW_MODEL,
                LIFE_CYCLE_LIVE_DATA,
                LEGACY_SUPPORT,
                WORK_MANAGER
            )
    }

    object Firebase : Library {
        object Version {
            const val AUTHENTICATION = "20.0.2"
            const val CLOUD_FIRE_STORE = "22.0.2"
            const val PLAY_SERVICE = "19.0.0"
            const val REMOTE_CONFIG = "20.0.3"
            const val ANALYTICS = "18.0.2"
            const val CLOUD_MESSAGING = "21.0.1"
            const val CRASHLYTICS = "17.4.0"
            const val FIREBASE_FUNCTION = "19.2.0"
            const val PLAY_CORE = "1.8.1"
        }

        // Firestore
        private const val FIRE_STORE =
            "com.google.firebase:firebase-firestore-ktx:${Version.CLOUD_FIRE_STORE}"

        // Remote config
        private const val REMOTE_CONFIG =
            "com.google.firebase:firebase-config-ktx:${Version.REMOTE_CONFIG}"
        private const val ANALYTICS =
            "com.google.firebase:firebase-analytics-ktx:${Version.ANALYTICS}"

        // Other Firebase/Play services deps
        private const val FIREBASE_AUTH =
            "com.google.firebase:firebase-auth-ktx:${Version.AUTHENTICATION}"
        private const val GOOGLE_PLAY =
            "com.google.android.gms:play-services-auth:${Version.PLAY_SERVICE}"

        private const val CLOUD_MESSAGING =
            "com.google.firebase:firebase-messaging:${Version.CLOUD_MESSAGING}"

        private const val CRASHLYTICS =
            "com.google.firebase:firebase-crashlytics:${Version.CRASHLYTICS}"

        private const val FIREBASE_FUNCTION =
            "com.google.firebase:firebase-functions-ktx:${Version.FIREBASE_FUNCTION}"

        private const val PLAY_CORE =
            "com.google.android.play:core-ktx:${Version.PLAY_CORE}"

        override val components: List<String>
            get() = listOf(
                FIRE_STORE,
                FIREBASE_AUTH,
                GOOGLE_PLAY,
                ANALYTICS,
                REMOTE_CONFIG,
                CLOUD_MESSAGING,
                CRASHLYTICS,
                FIREBASE_FUNCTION,
                PLAY_CORE
            )
    }

    object Timber {
        private const val VERSION = "4.7.1"
        const val TIMBER = "com.jakewharton.timber:timber:${VERSION}"
    }

    object Google {
        object Version {
            const val GSON = "2.8.6"
            const val FLEX_BOX = "2.0.1"
        }

        const val GSON = "com.google.code.gson:gson:${Version.GSON}"
        const val FLEX_BOX = "com.google.android:flexbox:${Version.FLEX_BOX}"
    }

    object Others {
        object Version {
            const val GLIDE = "4.11.0"
            const val ANIMATION = "2.4@aar"
            const val EASING = "2.4@aar"
            const val JSOUP = "1.13.1"
        }

        // Animation
        const val EASING_LIBRARY = "com.daimajia.easing:library:${Version.EASING}"
        const val ANIMATION_LIBRARY = "com.daimajia.androidanimations:library:${Version.ANIMATION}"

        //JSOUP html parser
        const val JSOUP = "org.jsoup:jsoup:${Version.JSOUP}"


        // Glide
        const val GLIDE = "com.github.bumptech.glide:glide:${Version.GLIDE}"

        object AnnotationProcessor {
            const val GLIDE = "com.github.bumptech.glide:compiler:${Version.GLIDE}"
        }
    }


    object FlowBinding {
        object Version {
            const val FLOW_BINDING: String = "0.12.0"
        }

        const val ANDROID: String =
            "io.github.reactivecircus.flowbinding:flowbinding-android:${Version.FLOW_BINDING}"
        const val SWIPE_REFRESH: String =
            "io.github.reactivecircus.flowbinding:flowbinding-swiperefreshlayout:${Version.FLOW_BINDING}"
        const val LIFE_CYCLE: String =
            "io.github.reactivecircus.flowbinding:flowbinding-lifecycle:${Version.FLOW_BINDING}"
    }

    object Network : Library {
        object Version {
            const val OK_HTTP: String = "4.7.2"
            const val RETROFIT: String = "2.9.0"
            const val MOSHI: String = "1.9.2"
            const val COROUTINES_ADAPTER = "0.9.2"
        }

        object AnnotationProcessor {
            const val MOSHI: String = "com.squareup.moshi:moshi-kotlin-codegen:${Version.MOSHI}"
        }

        private const val OK_HTTP: String = "com.squareup.okhttp3:okhttp:${Version.OK_HTTP}"
        private const val LOGGING_INTERCEPTOR: String =
            "com.squareup.okhttp3:logging-interceptor:${Version.OK_HTTP}"
        private const val RETROFIT: String = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
        private const val RETROFIT_MOSHI: String =
            "com.squareup.retrofit2:converter-moshi:${Version.RETROFIT}"
        const val RETROFIT_COROUTINE =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Version.COROUTINES_ADAPTER}"
        const val MOSHI: String = "com.squareup.moshi:moshi-kotlin:${Version.MOSHI}"

        override val components: List<String> = listOf(
            OK_HTTP, LOGGING_INTERCEPTOR, RETROFIT,
            RETROFIT_MOSHI, MOSHI, RETROFIT_COROUTINE
        )
    }

    object View : Library {
        object Version {
            const val MATERIAL = "1.2.1"
            const val CONSTRAINT_LAYOUT = "2.0.4"
            const val SHIMMER_LAYOUT: String = "0.5.0"
            const val FRAGMENT: String = "1.2.4"
            const val CARD_VIEW: String = "1.0.0"
            const val RECYCLER_VIEW: String = "1.1.0"
            const val EXO_PLAYER: String = "2.10.5"
            const val COIL: String = "0.11.0"
            const val SWIPE_REFRESH_LAYOUT: String = "1.1.0-rc01"
        }

        const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
        const val FRAGMENT: String = "androidx.fragment:fragment-ktx:${Version.FRAGMENT}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"
        const val SHIMMER_LAYOUT: String =
            "com.facebook.shimmer:shimmer:${Version.SHIMMER_LAYOUT}"
        const val CARD_VIEW: String = "androidx.cardview:cardview:${Version.CARD_VIEW}"
        const val RECYCLER_VIEW: String =
            "androidx.recyclerview:recyclerview:${Version.RECYCLER_VIEW}"
        const val EXO_PLAYER_CORE: String =
            "com.google.android.exoplayer:exoplayer-core:${Version.EXO_PLAYER}"
        const val EXO_PLAYER_UI: String =
            "com.google.android.exoplayer:exoplayer-ui:${Version.EXO_PLAYER}"
        const val COIL: String = "io.coil-kt:coil:${Version.COIL}"
        const val SWIPE_REFRESH_LAYOUT: String =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Version.SWIPE_REFRESH_LAYOUT}"

        override val components: List<String> =
            listOf(
                MATERIAL, CONSTRAINT_LAYOUT, FRAGMENT, SHIMMER_LAYOUT, CARD_VIEW, RECYCLER_VIEW,
                COIL, SWIPE_REFRESH_LAYOUT, EXO_PLAYER_UI, EXO_PLAYER_CORE
            )
    }

    object Cache : Library {
        object Version {
            const val ROOM: String = "2.2.5"
            const val SAFE_ROOM = "1.2.1"

        }

        object AnnotationProcessor {
            const val ROOM: String = "androidx.room:room-compiler:${Version.ROOM}"
        }

        private const val RUNTIME: String = "androidx.room:room-runtime:${Version.ROOM}"
        private const val COMMON: String = "androidx.room:room-common:${Version.ROOM}"
        private const val ROOM_KTX: String = "androidx.room:room-ktx:${Version.ROOM}"

        // Safe Room
        const val SAFE_ROOM = "com.commonsware.cwac:saferoom:${Version.SAFE_ROOM}"

        override val components: List<String> = listOf(
            RUNTIME, COMMON, ROOM_KTX, SAFE_ROOM
        )

    }

    object DI {
        object Version {
            const val JAVAX_INJECT: String = "1"
            const val DAGGER_HILT_ANDROID: String = "2.35.1"
            const val HILT_VIEW_MODEL = "1.0.0-alpha03"
            const val HILT_WORK_MANAGER = "1.0.0-beta01"
        }

        object AnnotationProcessor {
            const val DAGGER_HILT_ANDROID: String =
                "com.google.dagger:hilt-compiler:${Version.DAGGER_HILT_ANDROID}"
            const val HILT_VIEW_MODEL_COMPILER =
                "androidx.hilt:hilt-compiler:${Version.HILT_VIEW_MODEL}"
            const val HILT_WORK_MANAGER = "androidx.hilt:hilt-compiler:${Version.HILT_WORK_MANAGER}"
        }

        const val JAVAX_INJECT: String = "javax.inject:javax.inject:${Version.JAVAX_INJECT}"
        const val DAGGER_HILT_ANDROID: String =
            "com.google.dagger:hilt-android:${Version.DAGGER_HILT_ANDROID}"
        const val HILT_VIEW_MODEL =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Version.HILT_VIEW_MODEL}"
        const val HILT_WORK_MANAGER =
            "androidx.hilt:hilt-work:${Version.HILT_WORK_MANAGER}"
    }

    object Coroutines : Library {
        object Version {
            const val COROUTINE: String = "1.3.7"
        }

        const val CORE: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINE}"
        const val ANDROID: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINE}"

        override val components: List<String> = listOf(CORE, ANDROID)
    }
}