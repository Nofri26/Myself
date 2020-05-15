package com.squidward.myself.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.squidward.myself.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class MVAdapter(
    private val videoIds: Array<String>,
    private val lifecycle: Lifecycle
) :
    RecyclerView.Adapter<MVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val youTubePlayerView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_videos, parent, false) as YouTubePlayerView
        lifecycle.addObserver(youTubePlayerView)
        return ViewHolder(youTubePlayerView)
    }

    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int
    ) {
        viewHolder.cueVideo(videoIds[position])
    }

    override fun getItemCount(): Int {
        return videoIds.size
    }

    class ViewHolder(private val youTubePlayerView: YouTubePlayerView) :
        RecyclerView.ViewHolder(youTubePlayerView) {
        private var youTubePlayer: YouTubePlayer? = null
        private var currentVideoId: String? = null
        fun cueVideo(videoId: String?) {
            currentVideoId = videoId
            if (youTubePlayer == null) return
            youTubePlayer!!.cueVideo(videoId!!, 0f)
        }

        init {
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(initializedYouTubePlayer: YouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer
                    youTubePlayer!!.cueVideo(currentVideoId!!, 0f)
                }
            })
        }
    }

}