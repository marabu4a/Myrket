buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradleDeps.toolsBuildGradle)
        classpath(GradleDeps.kotlinGradlePlugin)
        classpath(GradleDeps.navSafeArgs)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}