plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kapt)
}

android {
    namespace = "ru.pyroman.medanalytica.data.token"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    api(project(":domain:token-domain"))

    // Coroutines
    implementation(libs.kotlinx.corountines.android)

    // Encrypted Shared Preferences
    implementation(libs.androidx.security.crypto)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}