object ConfigVersions {
    val compileSdkVersion = 32
    val buildToolsVersion = "32.0.0"
    val versionCode = 1
    val versionName = "1.0"
    val minSdkVersion = 23
    val targetSdkVersion = 32
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
    const val toolsBuildGradle = "7.0.4"
}

object Deps {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object GradleDeps {
    const val toolsBuildGradle = "com.android.tools.build:gradle:${Versions.toolsBuildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}