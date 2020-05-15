package com.squidward.myself.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.squidward.myself.Adapter.MusicAdapter
import com.squidward.myself.Adapter.MusicItem
import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_music.*

class MusicFragment : Fragment() {

    private val listMusicActivity = listOf(
        MusicItem(
            R.drawable.dgd1,
            "Betrayed By The Game",
            "Dance Gavin Dance"
        ),
        MusicItem(
            R.drawable.nd1,
            "December",
            "Neck Deep"
        ),
        MusicItem(
            R.drawable.bmth1,
            "Ludens",
            "Bring Me The Horizon"
        ),
        MusicItem(
            R.drawable.bmth2,
            "Wonderful Life",
            "Bring Me The Horizon"
        ),
        MusicItem(
            R.drawable.bmth3,
            "Drown",
            "Bring Me The Horizon"
        ),
        MusicItem(
            R.drawable.bmth2,
            "Mother Tongue",
            "Bring Me The Horizon"
        ),
        MusicItem(
            R.drawable.aa1,
            "The Final Episode",
            "Asking Alexandria"
        ),
        MusicItem(
            R.drawable.sws1,
            "James Dean & Audrey Hepburn",
            "Sleeping With Sirens"
        ),
        MusicItem(
            R.drawable.mmf1,
            "No Ordinary Love",
            "Memphis May Fire"
        ),
        MusicItem(
            R.drawable.cte1,
            "Machines",
            "Crown The Empire"
        ),
        MusicItem(
            R.drawable.cte2,
            "Memories of a Broken Heart",
            "Crown The Empire"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_music, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecyclerViewMusic.adapter =
            MusicAdapter(listMusicActivity)
        listRecyclerViewMusic.layoutManager = LinearLayoutManager(activity)
        listRecyclerViewMusic.setHasFixedSize(true)
    }

}
