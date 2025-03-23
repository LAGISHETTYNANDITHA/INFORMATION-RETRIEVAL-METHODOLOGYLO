plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.chatbot"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.chatbot"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // add the dependency for the Google AI client SDK for Android
    implementation("com.google.ai.client.generativeai: generativeai:0.6.0")

// Required for one-shot operations (to use 'ListenableFuture from Guava Android)
    implementation("com.google.guava:guava:31.0.1-android")

// Required for streaming operations (to use Publisher from Reactive Streams)
    implementation("org.reactivestreams: reactive-streams:1.0.4")
    implementation ("com.google.android.material:material:1.10.0")
    implementation ("com.google.ai:sdk:latest-version")
    implementation ("com.google.guava:guava:31.0.1-android")// For ListenableFuture and Futures
    implementation ("com.google.ai:sdk:latest-version")
}