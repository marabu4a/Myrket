plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("android")
}

android {
    compileSdk = ConfigVersions.compileSdkVersion
    buildToolsVersion = ConfigVersions.buildToolsVersion

    defaultConfig {
        applicationId = "com.example.myrket"
        minSdk = ConfigVersions.minSdkVersion
        targetSdk = ConfigVersions.targetSdkVersion
        versionCode = ConfigVersions.versionCode
        versionName = ConfigVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.constraintLayout)
    implementation(Deps.googleMaterial)
    implementation(Deps.lifecycleViewmodel)
    implementation(Deps.viewModelKtx)
    implementation(Deps.viewpager2)
    implementation(Deps.activityKtx)
    implementation(Deps.fragmentKtx)
    implementation(Deps.multiDex)

    kapt(Deps.roomCompiler)
    implementation(Deps.roomKtx)
    implementation(Deps.roomRuntime)
    implementation(Deps.roomGuava)
    implementation(Deps.roomTest)

    implementation(Deps.navFeature)
    implementation(Deps.navFragment)
    implementation(Deps.navUi)
    implementation(Deps.navTest)

    implementation(Deps.moshi)
    implementation(Deps.retrofit)
    implementation(Deps.okhttp)
    implementation(Deps.okhttpInterceptor)


    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espresso)
}