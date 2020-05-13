package com.squidward.myself.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squidward.myself.R
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryAdapter(private val galleryList: List<GalleryItem>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)

        return GalleryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val currentItem = galleryList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
    }

    override fun getItemCount() = galleryList.size

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.row_img
    }
}