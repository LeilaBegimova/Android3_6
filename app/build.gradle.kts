plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //kotlin
    kotlin("kapt")
}

android {
    namespace = "com.example.android3_6"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.android3_6"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Retrofit_2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")


    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    //OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // navigation
    val navVersion = "2.7.6"
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Room
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
}