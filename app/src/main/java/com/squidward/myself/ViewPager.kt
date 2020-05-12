package com.squidward.myself

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_view_pager.*
import kotlinx.android.synthetic.main.slide_item_container.*

class ViewPager : AppCompatActivity() {

    lateinit var preference : SharedPreferences
    val preferenceShowIntro = "Intro"

    //isi dari view pager
    private val introSliderAdapter = IntroSliderAdapter(
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
        preference = getSharedPreferences("IntroSlider", Context.MODE_PRIVATE)
        if (!preference.getBoolean(preferenceShowIntro, true)){
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        buttonNext.setOnClickListener{
            if (introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount){
                introSliderViewPager.currentItem += 1
            } else {
                buttonNext.text = "finish"
                Intent(applicationContext, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                    val editor = preference.edit()
                    editor.putBoolean(preferenceShowIntro, false)
                    editor.apply()
                }
            }
        }
        textSkip.setOnClickListener {
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }


    //membuat tampilan slider di bawah deskripsi
    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorsContainer.addView(indicators[i])
        }
    }

    //tampilan untuk indikator slide viewPager yang dipilih dan tidak
    private fun setCurrentIndicator(index : Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
