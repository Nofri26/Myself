package com.squidward.myself.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.squidward.myself.Fragments.*
import com.squidward.myself.R
import kotlinx.android.synthetic.main.activity_main.*

/*
* NIM   : 10117139
* Nama  : Nofrizal
* Kelas : AKB-4 / IF-4
* UTS
*
* Update :
* - 6 Mei =
*       - Membuat Halaman Awal (SplashScreen)
* - 9 Mei =
*       - ViewPager Selesai
* - 11 Mei =
*       - Membuat Shared Preference
*   12 Mei =
*       - selesai BottomNavigation
*   13 Mei =
*       - RecyclerView Daily Activity
*   14 Mei - 15 Mei =
*       - Menambahkan Item dan menu lain
*   16 Mei = Finish Project
*
* */

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
