package com.squidward.myself.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.squidward.myself.Fragments.MusicFragment
import com.squidward.myself.Fragments.Musicvideo

class MusicVideoAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MusicFragment()
            }
            else -> {
                return Musicvideo()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Music"
            else -> {
                return "Videos"
            }
        }
    }
}