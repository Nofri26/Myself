package com.squidward.myself.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squidward.myself.R
import kotlinx.android.synthetic.main.item_friend_list.view.*

class FriendAdapter(private val friendList: List<FriendItem>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_friend_list, parent, false)

        return FriendViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val currentItem = friendList[position]

        holder.imageView.setImageResource(currentItem.imageResourceF)
        holder.textView1.text = currentItem.textF1
    }

    override fun getItemCount() = friendList.size

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.friendImage
        val textView1 : TextView = itemView.friendName
    }
}