plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}


android {
    compileSdkVersion(Versions.COMPILE_SDK_VERSION)
    buildToolsVersion(Versions.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(Versions.MIN_SDK_VERSION)
        targetSdkVersion(Versions.TARGET_SDK_VERSION)
        versionCode = Releases.VERSION_CODE
        versionName = Releases.VERSION_NAME

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
}


dependencies {

    /** KOTLIN */
    implementation(Kotlin.STANDARD_LIBRARY)

    /** ANDROID X */
    implementation(AndroidX.CORE)
    implementation(AndroidX.APP_COMPAT)
    implementation(AndroidX.CONSTRAINT_LAYOUT)
    implementation(AndroidXLifecycle.LIFECYCLE_VIEWMODEL_KTX)
    implementation(AndroidXLifecycle.LIFECYCLE_LIVEDATA_KTX)
    implementation(AndroidXLifecycle.LIFECYCLE_SCOPE)
    implementation(AndroidXNavigation.FRAGMENT_KTX)
    implementation(AndroidXNavigation.UI_KTX)

    /** GOOGLE */
    implementation(Google.MATERIAL)
    
    /** KOIN */
    implementation(Koin.ANDROID)

    /** TESTING */
    testImplementation(Junit.JUNIT)
    androidTestImplementation(AndroidXTesting.JUNIT)

    /** Material */
    implementation(Google.MATERIAL)

    /** PICASSO */
    implementation(Picasso.PICASSO)

    /** MODULES */
    implementation(project(Connection.HOME))
    implementation(project(FeatureTools.RESOURCES))




}