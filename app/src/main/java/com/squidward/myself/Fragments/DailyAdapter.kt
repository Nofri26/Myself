package com.squidward.myself.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squidward.myself.R
import kotlinx.android.synthetic.main.item_daily_activity.view.*

class DailyAdapter(private val dailyList: List<DailyItem>) : RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_daily_activity, parent, false)

        return DailyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val currentItem = dailyList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }

    override fun getItemCount() = dailyList.size

    class DailyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.image_view
        val textView1 : TextView = itemView.text_view_1
        val textView2 : TextView = itemView.text_view_1
    }
}