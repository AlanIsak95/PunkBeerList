plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK_VERSION)
    buildToolsVersion(Versions.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = "com.test.project"
        minSdkVersion(Versions.MIN_SDK_VERSION)
        targetSdkVersion(Versions.TARGET_SDK_VERSION)
        versionCode = Releases.VERSION_CODE
        versionName = Releases.VERSION_NAME

        testInstrumentationRunner = AndroidXTesting.RUNNER
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures{
        viewBinding = true
        dataBinding = true
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/DEPENDENCIES.TXT")
    }
}

dependencies {
    /** KOTLIN */
    implementation(Kotlin.STANDARD_LIBRARY)

    /** ANDROID X */
    implementation(AndroidX.CORE)
    implementation(AndroidX.APP_COMPAT)
    implementation(AndroidX.CONSTRAINT_LAYOUT)
    implementation(AndroidXLifecycle.LIFECYCLE_VIEWMODEL_KTX)

    /** TESTING */
    testImplementation(Junit.JUNIT)
    androidTestImplementation(AndroidXTesting.JUNIT)
    androidTestImplementation(AndroidXTesting.ESPRESSO_CORE)

    /** KOIN */
    implementation(Koin.ANDROID)

    /** FEATURES */
    implementation(project(Feature.HOME))

    /** FEATURES TOOLS */
    implementation(project(FeatureTools.RESOURCES))

    /** CONNECTION */
    implementation(project(Connection.HOME))

    /** CONNECTION TOOLS*/
    implementation(project(ConnectionTools.HTTP_CLIENT))

}