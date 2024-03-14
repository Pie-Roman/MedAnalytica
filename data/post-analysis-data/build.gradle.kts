plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kapt)
}

android {
    namespace = "ru.pyroman.medanalytica.data.postanalysis"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    api(project(":domain:post-analysis-domain"))
    api(project(":domain:uid-domain"))
    api(project(":domain:token-domain"))

    // Retrofit
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.converter)

    // Coroutines
    implementation(libs.kotlinx.corountines.android)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}