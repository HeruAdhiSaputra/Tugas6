package com.example.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas2.R

class MyAdapter(private val namalist: ArrayList<ItemData>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemData: View) : RecyclerView.ViewHolder(itemData) {
        val gambar: ImageView = itemData.findViewById(R.id.imageView)
        val nama: TextView = itemData.findViewById(R.id.textView)
        val role: TextView = itemData.findViewById(R.id.textView2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(itemData)
    }

    override fun getItemCount(): Int = namalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namalist[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.role.text = currentItem.role
    }
}
