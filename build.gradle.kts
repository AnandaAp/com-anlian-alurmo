buildscript {
    dependencies {
        val gmsVersion = "4.3.15"
        classpath("com.google.gms:google-services:$gmsVersion")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    val appVersion = "8.1.0-alpha07"
    val kotlinVersion = "1.8.10"
    val kspVersion = "1.8.10-1.0.9"
    val hiltVersion = "2.44"

    id("com.android.application") version appVersion apply false
    id("com.android.library") version appVersion apply false
    id("org.jetbrains.kotlin.android") version kotlinVersion apply false
    id("com.google.devtools.ksp") version kspVersion apply false
    id("com.google.dagger.hilt.android") version hiltVersion apply false
}

//tasks.register("clean", Delete) {
//    delete("rootProject.buildDir")
//}