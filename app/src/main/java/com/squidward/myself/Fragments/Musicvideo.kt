package com.squidward.myself.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squidward.myself.Adapter.MVAdapter
import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_videos.*


class Musicvideo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_videos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        rv_mv.setHasFixedSize(true)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rv_mv.layoutManager = mLayoutManager
        val videoIds = arrayOf(
            "XKJiOhoOJvY",
            "akRHNEK_5is",
            "P2DEipI1obI",
            "JOAWOLaxcCA",
            "ATJYac_dORw"
        )
        val recyclerViewAdapter: RecyclerView.Adapter<*> =
            MVAdapter(videoIds, this.lifecycle)
        rv_mv.adapter = recyclerViewAdapter
    }
}