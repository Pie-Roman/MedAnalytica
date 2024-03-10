plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kapt)
}

android {
    namespace = "ru.pyroman.medanalytica.data.analysisgraph"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    api(project(":domain:analysis-graph-domain"))
    api(project(":domain:uid-domain"))
    api(project(":data:uid-data"))

    // Retrofit
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.converter)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)

    // Coroutines
    implementation(libs.kotlinx.corountines.android)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}