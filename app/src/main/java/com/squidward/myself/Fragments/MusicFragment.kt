package com.squidward.myself.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_daily_activity.*
import kotlinx.android.synthetic.main.fragment_music.*

class MusicFragment : Fragment() {

    private val listMusicActivity = listOf(
        MusicItem(R.drawable.ic_image, "line 1", "line 2"),
        MusicItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        MusicItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        MusicItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        MusicItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        MusicItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        MusicItem(R.drawable.ic_accessibility, "line 1", "line 2"),
        MusicItem(R.drawable.ic_home, "line 1", "line 2")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_music, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecyclerViewMusic.adapter = MusicAdapter(listMusicActivity)
        listRecyclerViewMusic.layoutManager = LinearLayoutManager(activity)
        listRecyclerViewMusic.setHasFixedSize(true)
    }

}
