package com.example.tgs_retrofit_ppapba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("image")
        // Ambil data lain sesuai kebutuhan

        // Gunakan data untuk mengisi komponen UI
        val nameTextView = findViewById<TextView>(R.id.detail_name)
        nameTextView.text = name

        // Gunakan Glide untuk menampilkan gambar
        val imageView = findViewById<ImageView>(R.id.detail_image)
        Glide.with(this)
            .load(image)
            .error(R.drawable.ic_launcher_background) // Ganti dengan gambar placeholder
            .into(imageView)
    }
}