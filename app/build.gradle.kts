import Deps.androidx
import Deps.glide
import Deps.hilt
import Deps.navigation
import Deps.network
import Deps.testDependencies

plugins {
    id(plugin.BuildPlugins.ANDROID_APP)
    id(plugin.BuildPlugins.KOTLIN_ANDROID)
    id(plugin.BuildPlugins.KSP)
    id(plugin.BuildPlugins.KAPT)
    id(plugin.BuildPlugins.HILT)
    id("kotlin-parcelize")
}

android {
    namespace = Build.BuildConfig.APP_NAME
    compileSdk = Build.BuildConfig.COMPILE_SDK

    defaultConfig {
        applicationId = Build.BuildConfig.APP_NAME
        minSdk = Build.BuildConfig.MIN_SDK
        targetSdk = Build.BuildConfig.TARGET_SDK_VERSION
        versionCode = Release.ReleaseConfig.VERSION_CODE
        versionName = Release.ReleaseConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    }
}

dependencies {
    implementation("androidx.navigation:navigation-fragment-ktx:2.9.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.9.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.9.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.9.5")
    implementation("androidx.camera:camera-camera2-pipe:1.6.0-alpha01")
    // android
    androidx()
    // Navigation Component
    navigation()
    // testDeps
    testDependencies()
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
    // Glide
    glide()
    // Shimmer
    implementation("com.facebook.shimmer:shimmer:0.5.0")
    // MVVM
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.2")
    // Hilt
    hilt()
    // AllNetwork Case
    network()

    implementation("androidx.security:security-crypto:1.1.0-alpha04")
}
