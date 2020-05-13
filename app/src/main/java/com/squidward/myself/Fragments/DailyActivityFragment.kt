package com.squidward.myself.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_daily_activity.*

data class DailyItem(val imageResourceD : Int, val textD1 : String, val text2 : String)
data class FriendItem(val imageResourceF : Int, val textF1 : String)

class DailyActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_daily_activity, container, false)

    private val listFriendActivity = listOf(
        FriendItem(R.drawable.gunung_putri2, "Nofri"),
        FriendItem(R.drawable.gunung_putri, "Nofri"),
        FriendItem(R.drawable.tea_house1, "Nofri")
    )

    private val listDailyActivity = listOf(
        DailyItem(R.drawable.ic_image, "line 1", "line 2"),
        DailyItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        DailyItem(R.drawable.ic_home, "line 1", "line 2")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecycleViewFriend.adapter = FriendAdapter(listFriendActivity)
        listRecycleViewFriend.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        listRecycleViewFriend.setHasFixedSize(true)

        listRecycleViewDaily.adapter = DailyAdapter(listDailyActivity)
        listRecycleViewDaily.layoutManager = LinearLayoutManager(activity)
        listRecycleViewDaily.setHasFixedSize(true)
    }

}
