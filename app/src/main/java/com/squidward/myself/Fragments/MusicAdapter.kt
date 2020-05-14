package com.squidward.myself.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squidward.myself.R
import kotlinx.android.synthetic.main.item_daily_activity.view.*
import kotlinx.android.synthetic.main.item_music.view.*

data class MusicItem(val imageResource: Int, val text1: String, val text2: String)

class MusicAdapter (private val musicList: List<MusicItem>) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)

        return MusicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentItem = musicList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }

    override fun getItemCount() = musicList.size

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView : ImageView = itemView.imageMusic
        val textView1 : TextView = itemView.titleMusic
        val textView2 : TextView = itemView.singer
    }
}

// ImageView.setImageResorce()