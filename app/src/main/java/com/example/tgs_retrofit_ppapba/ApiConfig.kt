package com.example.tgs_retrofit_ppapba

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
// bertanggung jawab untuk konfigurasi Retrofit, mengatur baseUrl,
// dan menyediakan instance Retrofit yang telah dikonfigurasi.
object ApiConfig {

    const val baseUrl = "https://rickandmortyapi.com/api/"
// yang menentukan baseUrl untuk panggilan API.
// Semua endpoint akan ditambahkan ke baseUrl ini.

    fun getRetrofit(): Retrofit{
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
// Fungsi ini mengembalikan instance Retrofit yang telah dikonfigurasi dengan baseUrl dan konverter Gson.
// GsonConverterFactory digunakan untuk mengonversi respon dari server menjadi objek Kotlin
// menggunakan library Gson.

    fun getService(): ApiService{
        return  getRetrofit().create(ApiService::class.java)
    }
// Fungsi ini mengembalikan instance dari sebuah interface ApiService yang dibuat oleh Retrofit.
// Interface ini akan digunakan untuk mendefinisikan endpoint-endpoint yang ingin diakses dari API.
// Dengan menggunakan getRetrofit().create(ApiService::class.java), kita menghasilkan implementasi dari
// interface ApiService yang dapat digunakan untuk melakukan panggilan ke API.
}
