buildscript {
    dependencies {
        val gms_version = "4.3.15"
        classpath("com.google.gms:google-services:$gms_version")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    val app_version = "8.1.0-alpha07"
    val kotlin_version = "1.8.10"
    val ksp_version = "1.8.10-1.0.9"
    val hilt_version = "2.44"

    id("com.android.application") version "$app_version" apply false
    id("com.android.library") version "$app_version" apply false
    id("org.jetbrains.kotlin.android") version "$kotlin_version" apply false
    id("com.google.devtools.ksp") version "$ksp_version" apply false
    id("com.google.dagger.hilt.android") version "$hilt_version" apply false
}

//tasks.register("clean", Delete) {
//    delete("rootProject.buildDir")
//}