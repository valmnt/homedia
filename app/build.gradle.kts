@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.androidx.baselineprofile)
    alias(libs.plugins.hilt)
}

android {
    compileSdk = 34

    defaultConfig {
        namespace = "fr.nexhub.homedia"
        minSdk = 28
        targetSdk = 34
        versionCode = 2
        versionName = "1.4.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
        create("benchmark") {
            initWith(buildTypes.getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidComposeCompiler.get()
    }

    kapt {
        correctErrorTypes = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(mapOf("path" to ":utils")))
    implementation(project(mapOf("path" to ":player")))
    implementation(project(mapOf("path" to ":exoplayer")))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.security.crypto)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.androidx.compose.bom)
    implementation(libs.bundles.compose.tv)
    implementation(libs.bundles.compose.accompanist)

    implementation(libs.hilt.android)

    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.profileinstaller)
    "baselineProfile"(project(":baselineprofile"))

    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.qrcode)
    implementation(libs.line.awesome.icons)

    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation(libs.jellyfin.core.android)

    androidTestImplementation(platform(libs.compose.bom))
}
