package com.squidward.myself.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.squidward.myself.Fragments.*
import com.squidward.myself.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val dailyActivityFragment = DailyActivityFragment()
        val galleryFragment = GalleryFragment()
        val musicFragment = MusicVideoFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_dailyActivity -> makeCurrentFragment(dailyActivityFragment)
                R.id.ic_gallery -> makeCurrentFragment(galleryFragment)
                R.id.ic_music -> makeCurrentFragment(musicFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            replace(R.id.flWrapper,fragment, fragment.javaClass.getSimpleName())
            commit()
        }
}
