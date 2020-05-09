package com.squidward.myself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPager : AppCompatActivity() {

    private val introSlideAdapter = IntroSlideAdapter(
        listOf(
            IntroSlide(
                "Selamat Datang",
                "Aplikasi ini berisi data diri dan berbagai hal tenatang saya.",
                R.drawable.squidward_icon
            ),
            IntroSlide(
                "Daily Activity",
                "Disini saya menceritakan keseharian saya, mulai dari bangun tidur hingga tidur lagi",
                R.drawable.squidward_welcom
            ),
            IntroSlide(
                "Gallery and Music",
                "Beberapa Foto saya dan Musik yang saya suka",
                R.drawable.ic_music_video_black_24dp
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        IntroSlideViewPager.adapter = introSlideAdapter
    }
}
