plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kapt)
}

android {
    namespace = "ru.pyroman.medanalytica.data.profile"
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
    api(project(":domain:uid-domain"))
    api(project(":domain:token-domain"))
    api(project(":domain:profile-domain"))

    api(project(":common:utils"))

    // Retrofit
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.converter)

    // Coroutines
    implementation(libs.kotlinx.corountines.android)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}