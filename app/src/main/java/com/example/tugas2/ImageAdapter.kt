package com.example.tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (private val databselist: ArrayList<Image>):
RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    var onItemClick : ((Image) -> Unit)? = null

    class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id._image)
        val imageTitle : TextView = itemView.findViewById(R.id._imageTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return databselist.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
      val databse = databselist[position]
        holder.imageView.setImageResource(databse.imageSource)
        holder.imageTitle.text = databse.imageTitle

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(databse)
        }
    }
}