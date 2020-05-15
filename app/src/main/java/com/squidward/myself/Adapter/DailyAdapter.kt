package com.squidward.myself.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squidward.myself.R
import kotlinx.android.synthetic.main.item_daily_activity.view.*

data class DailyItem(val imageResourceD : Int, val textD1 : String, val text2 : String)

class DailyAdapter(private val dailyList: List<DailyItem>) : RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_daily_activity, parent, false)

        return DailyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val currentItem = dailyList[position]

        holder.imageView.setImageResource(currentItem.imageResourceD)
        holder.textView1.text = currentItem.textD1
        holder.textView2.text = currentItem.text2
    }

    override fun getItemCount() = dailyList.size

    class DailyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.image_view
        val textView1 : TextView = itemView.text_view_1
        val textView2 : TextView = itemView.text_view_2
    }
}