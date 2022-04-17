object ConfigVersions {
    const val compileSdkVersion = 32
    const val buildToolsVersion = "32.0.0"
    const val versionCode = 1
    const val versionName = "1.0"
    const val minSdkVersion = 23
    const val targetSdkVersion = 32
}

object Versions {
    const val kotlin = "1.6.0"
    const val coreKtx = "1.7.0"
    const val appcompat = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val googleMaterial = "1.4.0"
    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"
    const val toolsBuildGradle = "7.1.1"
    const val lifecycle = "2.2.0"
    const val room = "2.4.1"
    const val navGraph = "2.4.1"
    const val retrofit = "2.9.0"
    const val moshi = "1.13.0"
    const val okhttp = "4.9.3"
    const val activityKtx = "1.4.0"
    const val fragmentKtx = "1.2.5"
    const val multiDex = "2.0.1"
    const val viewModelKtx = "2.4.0"
    const val viewPager2 = "1.0.0"
    const val hilt = "2.38.1"
}

object Deps {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
    //const val livedataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.4.0"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"

    const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomGuava = "androidx.room:room-guava:${Versions.room}"
    const val roomTest = "androidx.room:room-testing:${Versions.room}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navGraph}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navGraph}"
    const val navFeature = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navGraph}"
    const val navTest = "androidx.navigation:navigation-testing:${Versions.navGraph}"

    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object GradleDeps {
    const val toolsBuildGradle = "com.android.tools.build:gradle:${Versions.toolsBuildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navGraph}"
    const val hiltGradle = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

object ConfigFields {
    const val tmdbKey = "\"a6cc4920784ca5f0ee9534c96631634d\""
}