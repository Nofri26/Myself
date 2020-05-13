package com.squidward.myself.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_daily_activity.*
import kotlinx.android.synthetic.main.fragment_gallery.*

data class GalleryItem(val imageResource : Int)

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_gallery, container, false)

    private val listGallery = listOf(
        GalleryItem(R.drawable.curug),
        GalleryItem(R.drawable.gunung_putri2),
        GalleryItem(R.drawable.gunung_putri),
        GalleryItem(R.drawable.patahan),
        GalleryItem(R.drawable.tea_house1),
        GalleryItem(R.drawable.tea_house2),
        GalleryItem(R.drawable.tea_house3),
        GalleryItem(R.drawable.tebing)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listRecycleViewGallery.adapter = GalleryAdapter(listGallery)
        listRecycleViewGallery.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        listRecycleViewGallery.setHasFixedSize(true)
    }

}

