// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories.applyDefault()
    repositories.maven("https://maven.fabric.io/public")
    repositories.maven("https://s3.amazonaws.com/repo.commonsware.com")
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        classpath("com.google.gms:google-services:4.3.5")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.5.1")
    }
}

allprojects {
    repositories.applyDefault()
    repositories.flatDir("dirs" to "libs")
    repositories.maven("https://maven.fabric.io/public")
    repositories.maven("https://s3.amazonaws.com/repo.commonsware.com")
}

subprojects {
    applySpotless
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// Make spotless run before intensive tasks (resource processing, code generation, compilation, etc)
tasks.whenTaskAdded {
    if (name == "preBuild") {
        mustRunAfter("spotlessCheck")
    }
}