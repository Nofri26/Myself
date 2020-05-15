package com.squidward.myself.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.squidward.myself.Adapter.DailyAdapter
import com.squidward.myself.Adapter.DailyItem
import com.squidward.myself.Adapter.FriendAdapter
import com.squidward.myself.Adapter.FriendItem

import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_daily_activity.*

class DailyActivityFragment : Fragment() {

    private val listFriendActivity = listOf(
        FriendItem(
            R.drawable.hafidh,
            "Hafidh Fajar Ashidiq"
        ),
        FriendItem(
            R.drawable.juan,
            "Juan Lazuardo"
        ),
        FriendItem(
            R.drawable.adit,
            "Aditya"
        ),
        FriendItem(
            R.drawable.iqbal,
            "Iqbal Atma Muliawan"
        ),
        FriendItem(
            R.drawable.angga,
            "Angga Prakasa"
        ),
        FriendItem(
            R.drawable.adhitya,
            "Adhitya Pratama"
        )
    )

    private val listDailyActivity = listOf(
        DailyItem(
            R.drawable.ic_wakeup,
            "04.30",
            "Bangun dan kemudian sholat"
        ),
        DailyItem(
            R.drawable.ic_reading,
            "04.50",
            "Main Game atau baca manga(komik)"
        ),
        DailyItem(
            R.drawable.ic_run,
            "06.15",
            "Lari pagi"
        ),
        DailyItem(
            R.drawable.ic_meal,
            "07.30",
            "Sarapan kupat tahu atau nasi kuning dekat rumah"
        ),
        DailyItem(
            R.drawable.ic_campus,
            "08.00",
            "Pergi ke kampus jika ada kelas, kalo ga ada kelas main game"
        ),
        DailyItem(
            R.drawable.ic_work,
            "13.30",
            "Bantu konveksi orang tua dirumah"
        ),
        DailyItem(
            R.drawable.ic_coffe,
            "15.30",
            "Sholat lalu nongkrong ke kosan teman"
        ),
        DailyItem(
            R.drawable.ic_watching,
            "18.00",
            "Sholat lalu nonton youtube/anime bajakan"
        ),
        DailyItem(
            R.drawable.ic_fortnite,
            "19.30",
            "Sholat lalu mabar/nugas kalo ada"
        ),
        DailyItem(
            R.drawable.ic_sleeping,
            "22.00",
            "Tidur"
        )
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_daily_activity, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecycleViewFriend.adapter =
            FriendAdapter(listFriendActivity)
        listRecycleViewFriend.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        listRecycleViewFriend.setHasFixedSize(true)

        listRecycleViewDaily.adapter =
            DailyAdapter(listDailyActivity)
        listRecycleViewDaily.layoutManager = LinearLayoutManager(activity)
        listRecycleViewDaily.setHasFixedSize(true)
    }

}
