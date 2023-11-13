package com.example.tgs_retrofit_ppapba

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    // etode HTTP GET ke endpoint "character" di API. Dalam konteks ini, endpoint "character"
    // akan ditambahkan ke baseUrl yang telah diatur sebelumnya dalam objek ApiConfig.
    fun getRick(): Call<ResponseRick>
    // ResponseRick: kelas model yang digunakan untuk mengonversi respon JSON dari
// endpoint "character" menjadi objek Kotlin. Struktur ResponseRick akan mencerminkan struktur data yang
// terdapat di  API.
}