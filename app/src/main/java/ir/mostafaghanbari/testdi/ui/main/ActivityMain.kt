package ir.mostafaghanbari.testdi.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ir.mostafaghanbari.testdi.R
import ir.mostafaghanbari.testdi.ui.auth.FragmentLogIn
import ir.mostafaghanbari.testdi.ui.auth.FragmentLogUp

/**
 * ## Host Of [FragmentAdd] And [FragmentAdd] And [FragmentDetail]
 *
 * we using AndroidEntryPoint annotation because child fragment used this annotation
 */
@AndroidEntryPoint
class ActivityMain:AppCompatActivity() {

    lateinit var username:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = intent?.extras?.getString("username") ?: ""

    }

}