package com.squidward.myself.Fragments

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squidward.myself.R
import kotlinx.android.synthetic.main.fragment_profile.*
import android.content.ActivityNotFoundException


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnInstagram.setOnClickListener{
            val uri = Uri.parse("https://www.instagram.com/nofri26/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            try {
                Toast.makeText(activity, "Open Instagram", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/nofri26/")))
            }

        }
        btnFacebook.setOnClickListener{
            val uri = Uri.parse("fb://profile/nofri37")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            try {
                Toast.makeText(activity, "Open Facebook", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nofri37/")))
            }

        }
        btnWhasapp.setOnClickListener{
            val uri = Uri.parse("https://wa.me/62895628087589/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            try {
                Toast.makeText(activity, "Open WhatsApp", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/62895628087589/")))
            }

        }
        findMe.setOnClickListener{
            val uri = Uri.parse("geo:-6.925959, 107.648638?q=6°55'33.6\"S+107°38'55.2\"E")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            try {
                Toast.makeText(activity, "Open Maps", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:-6.925959, 107.648638?q=6°55'33.6\"S+107°38'55.2\"E")))
            }

        }

        about.setOnClickListener {
            val alertDialog =
                AlertDialog.Builder(activity).create()
            alertDialog.setTitle("App Version")
            alertDialog.setMessage("Version 1.0.0")
            alertDialog.setButton(
                AlertDialog.BUTTON_NEUTRAL, "OK"
            ) { dialog, _ -> dialog.dismiss() }
            alertDialog.show()
        }

    }
}
