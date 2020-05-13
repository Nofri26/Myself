package com.squidward.myself.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_daily_activity.*

data class DailyItem(val imageResource : Int, val text1 : String, val text2 : String)

class DailyActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_daily_activity, container, false)

    private val listDailyActivity = listOf(
        DailyItem(R.drawable.ic_image, "line 1", "line 2"),
        DailyItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        DailyItem(R.drawable.ic_home, "line 1", "line 2")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listRecycleView.adapter = DailyAdapter(listDailyActivity)
        listRecycleView.layoutManager = LinearLayoutManager(activity)
        listRecycleView.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<DailyItem> {
        val list = ArrayList<DailyItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_home
                1 -> R.drawable.ic_image
                else -> R.drawable.ic_accessibility
            }
            val item = DailyItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }

}
