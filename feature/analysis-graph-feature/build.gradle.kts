plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kapt)
}

android {
    namespace = "ru.pyroman.medanalytica.feature.analysisgraph"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    defaultConfig {
        minSdk = 24
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}

dependencies {

    api(project(":base:uikit"))
    api(project(":domain:analysis-graph-domain"))
    api(project(":data:analysis-graph-data"))

    api(project(":common:navigation:api"))

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.foundation)
    implementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.compose.uitooling)
    implementation(libs.androidx.compose.uitoolingpreview)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.valentinilk.shimmer.compose)

    implementation(libs.vico.compose)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}