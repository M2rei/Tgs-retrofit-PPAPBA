package com.example.tgs_retrofit_ppapba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rick = findViewById<RecyclerView>(R.id.rv_character)
// digunakan untuk menginisialisasi objek RecyclerView dengan menggunakan ID rv_character yang
//  terdapat di layout activity_main.xml
        ApiConfig.getService().getRick().enqueue(object : Callback<ResponseRick>{
            override fun onResponse(call: Call<ResponseRick>, response: Response<ResponseRick>) {
                if (response.isSuccessful){
                    val responseRick = response.body()
                    val dataRick = responseRick?.results
                    val rickAdapter = RickAdapter(dataRick)
                    rick.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        rickAdapter.notifyDataSetChanged()
                        adapter = rickAdapter
                    }
                }
            }
// Ketika respons dari server diterima, memeriksa apakah respons tersebut berhasil (response.isSuccessful).
// Jika ya,mengambil data dari respons menggunakan response.body().
//  kemudian membuat adapter (RickAdapter) dengan data tersebut dan mengatur RecyclerView
//  untuk menampilkan data menggunakan adapter tersebut.
            override fun onFailure(call: Call<ResponseRick>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })


    }

}