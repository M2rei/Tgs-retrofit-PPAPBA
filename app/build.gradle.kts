plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.tgs_retrofit_ppapba"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tgs_retrofit_ppapba"
        minSdk = 21
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //RETORFIT
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    retrofit: Ini adalah dependensi inti Retrofit.
//    Itu mencakup kelas-kelas dan fungsi-fungsi dasar untuk membuat dan mengeksekusi panggilan jaringan.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

//    converter-gson: Ini adalah dependensi tambahan untuk Retrofit yang menyediakan konverter Gson.
//    Gson digunakan untuk mengonversi JSON ke objek Java dan sebaliknya.
//    Dengan menggunakan converter-gson, Retrofit dapat secara otomatis mengonversi respon
//    JSON dari server menjadi objek Java.

    // Glide
//    Glide adalah pustaka untuk memuat dan menampilkan gambar secara efisien dalam aplikasi Android.
//    Dependensi menunjukkan bahwa aplikasi ini menggunakan Glide versi 4.16.0.
    implementation ("com.github.bumptech.glide:glide:4.16.0")
//    glide: Ini adalah dependensi utama untuk pustaka Glide. Pustaka ini menyediakan metode-metode
//    untuk memuat gambar dari berbagai sumber, seperti URL, file, atau bahkan resource di dalam aplikasi.
}