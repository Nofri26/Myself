package com.squidward.myself.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.squidward.myself.R
import kotlinx.android.synthetic.main.item_videos.view.*


data class VideosItem(val videoIds: String, val text1: String)

internal class VideosAdapter( private val videoList: List<VideosItem>, private val lifecycle: Lifecycle) : RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val youTubePlayerView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_videos, parent, false) as YouTubePlayerView
        lifecycle.addObserver(youTubePlayerView)
        return ViewHolder(youTubePlayerView)
    }

    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int
    ) {
        val currentItem = videoList[position]

        viewHolder.cueVideo(currentItem.videoIds)
        viewHolder.textView1.text = currentItem.text1
    }

    override fun getItemCount()= videoList.size

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var youTubePlayer: YouTubePlayer? = null
        private var currentVideoId: String? = null

        fun ViewHolder (itemView: View) {
            val playerView: YouTubePlayerView = itemView.youtubePlayerView
            playerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(initializedYouTubePlayer: YouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer
                    youTubePlayer!!.cueVideo(currentVideoId!!, 0f)
                }
            })
        }

        fun cueVideo(videoId: String) {
            currentVideoId = videoId
            if (youTubePlayer == null) return
            youTubePlayer!!.cueVideo(videoId, 0f)
        }
        val textView1 : TextView = itemView.titleVideos
    }

}