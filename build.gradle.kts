// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
        mavenCentral()
    }
    dependencies {
        classpath(AndroidTools.BUILD_GRADLE)
        classpath(Kotlin.GRADLE_PLUGIN)

    }

}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}