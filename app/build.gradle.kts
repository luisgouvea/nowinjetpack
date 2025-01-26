plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.nowinjetpack"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.nowinjetpack"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
    }
}

dependencies {

    //TODO: Future - Improvements libs.versions.toml and organize in specific modules

    val navigation_version = "2.4.1"

    // AndroidX
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
//    implementation("androidx.lifecycle:lifecycle-common:2.4.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_version")
//    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation(project(":core:common"))
    implementation(project(":core:network"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":feature:marvel"))

    // Koin
    implementation(libs.koin)
    implementation(libs.koin.android.compat)
    implementation(libs.koin.test.junit)


    implementation(libs.lifecycle.viewmodel)

    //implementation ("androidx.activity:activity-ktx:1.9.0")

    // Hilt
    val hilt_version = "2.47"
    implementation ("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")

    implementation(libs.lifecycle.viewmodel)

    val activity_version = "1.6.1"
    implementation("androidx.activity:activity-ktx:$activity_version")

    implementation(libs.core.ktx)


}

kapt {
    correctErrorTypes = true
}