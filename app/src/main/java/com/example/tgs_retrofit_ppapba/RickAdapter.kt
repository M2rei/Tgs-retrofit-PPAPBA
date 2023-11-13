package com.example.tgs_retrofit_ppapba

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickAdapter(val dataRick: List<ResultsItem?>?): RecyclerView.Adapter<RickAdapter.MyViewHolder>(){
    // RickAdapter adalah kelas adapter untuk RecyclerView.
    //Konstruktor menerima parameter dataRick,
    // yang merupakan daftar karakter "Rick" yang akan ditampilkan dalam RecyclerView.

    class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
// MyViewHolder adalah kelas yang bertanggung jawab untuk menyimpan referensi ke
// elemen tampilan dalam setiap item RecyclerView.
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val nameRick = view.findViewById<TextView>(R.id.item_name_rick)
        val satatusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
//  digunakan untuk membuat dan menginisialisasi instance MyViewHolder untuk setiap item RecyclerView.
    }

    override fun getItemCount(): Int {
        if (dataRick != null){
            return dataRick.size
        }
        return 0
    }
// mengembalikan jumlah total item dalam RecyclerView. Jika dataRick tidak null,
// maka jumlah item akan sesuai dengan ukuran dataRick, jika tidak, jumlah item adalah 0.

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//  digunakan untuk mengikat data ke ViewHolder dan menentukan tampilan untuk setiap item dalam RecyclerView.
        holder.nameRick.text = dataRick?.get(position)?.name
        holder.satatusRick.text = dataRick?.get(position)?.status
        holder.speciesRick.text = dataRick?.get(position)?.species

        Glide.with(holder.imgRick)
            .load(dataRick?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgRick)
// Data karakter "Rick" (nama, status, spesies, dan URL gambar) diambil dari dataRick dan diatur ke elemen
// tampilan dalam setiap item RecyclerView.
// Gambar diambil menggunakan Glide untuk memuatnya ke dalam ImageView.
// Jika terjadi kesalahan dalam memuat gambar, gambar default
// (R.drawable.ic_launcher_background) akan ditampilkan.
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("name", dataRick?.get(position)?.name)
            intent.putExtra("image", dataRick?.get(position)?.image)


            holder.itemView.context.startActivity(intent)
//  sebuah OnClickListener ditambahkan ke setiap item RecyclerView.
//  Jika item diklik, akan dibuat intent untuk memulai DetailActivity,
 //  dan data karakter ("Rick") yang terkait akan dikirim sebagai ekstra melalui intent.
        }
    }


}