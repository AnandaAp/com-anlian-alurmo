plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-kapt")
    id ("com.google.devtools.ksp")
    id ("com.google.gms.google-services")
}
pluginManager.withPlugin("kotlin-kapt") {
    configure<org.jetbrains.kotlin.gradle.plugin.KaptExtension> { useBuildCache = true }
}

android {
    namespace = "com.anlian.alurmo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.anlian.alurmo"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    sourceSets {
        named("main") {
            java.srcDir("src/main/java")
            kotlin.srcDir("src/main/kotlin")
        }
        named("androidTest") {
            java.srcDir("src/androidTest/java")
            kotlin.srcDir("src/androidTest/kotlin")
        }
        named("test") {
            java.srcDir("src/test/java")
            kotlin.srcDir("src/test/kotlin")
        }
    }

    buildTypes {
        named("debug"){
            isMinifyEnabled  = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = true
            isJniDebuggable = true
//            signingConfig signingConfigs.debug
        }
        named("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            isJniDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    lint {
        quiet = true
        baseline = file("lint-baseline.xml")
        checkAllWarnings = false
        ignoreWarnings = true
        warningsAsErrors = false
        abortOnError = false
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2023.01.00")
    val firebaseBom = platform("com.google.firebase:firebase-bom:31.2.3")
    val coil = "2.2.2"
    val accompanist = "0.29.1-alpha"
    val roomDatabase = "2.5.0"
    val hilt = "1.0.0"
    val hiltCompose = "2.45"
    val glide = "4.15.0"

    implementation(composeBom)
    implementation(firebaseBom)
    androidTestImplementation(composeBom)

    //Using BOM
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material3:material3")
    implementation ("com.google.firebase:firebase-analytics-ktx")
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.material3:material3-window-size-class")

    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
    debugImplementation ("androidx.compose.ui:ui-tooling")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")

    //Using Version
    implementation ("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation ("com.google.android.gms:play-services-auth:20.4.1")
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation ("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    //hilt
    implementation ("com.google.dagger:hilt-android:$hiltCompose")
    kapt ("com.google.dagger:hilt-android-compiler:$hiltCompose")
    kapt ("androidx.hilt:hilt-compiler:$hilt")
    implementation ("androidx.hilt:hilt-work:$hilt")
    implementation ("androidx.work:work-runtime-ktx:2.8.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")

    //coil
    implementation ("io.coil-kt:coil:$coil")
    implementation ("io.coil-kt:coil-compose:$coil")

    //glide
    implementation ("com.github.bumptech.glide:glide:$glide")
    ksp ("com.github.bumptech.glide:compiler:$glide")

    //room database
    implementation ("androidx.room:room-runtime:$roomDatabase")
    ksp ("androidx.room:room-compiler:$roomDatabase")
    implementation ("androidx.room:room-ktx:$roomDatabase")

    //accompanist
    implementation ("com.google.accompanist:accompanist-permissions:$accompanist")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:$accompanist")
    implementation ("com.google.accompanist:accompanist-themeadapter-appcompat:$accompanist")
    implementation ("com.google.accompanist:accompanist-themeadapter-material:$accompanist")
    implementation ("com.google.accompanist:accompanist-themeadapter-material3:$accompanist")
    implementation ("com.google.accompanist:accompanist-themeadapter-core:$accompanist")
    implementation ("com.google.accompanist:accompanist-pager:$accompanist")
    implementation ("com.google.accompanist:accompanist-pager-indicators:$accompanist")
    implementation ("com.google.accompanist:accompanist-placeholder-material:$accompanist")
    implementation ("com.google.accompanist:accompanist-drawablepainter:$accompanist")
    implementation ("com.google.accompanist:accompanist-flowlayout:$accompanist")
    implementation ("com.google.accompanist:accompanist-navigation-animation:$accompanist")
    implementation ("com.google.accompanist:accompanist-navigation-material:$accompanist")
    implementation ("com.google.accompanist:accompanist-webview:$accompanist")
    implementation ("com.google.accompanist:accompanist-adaptive:$accompanist")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
    useBuildCache = true
}