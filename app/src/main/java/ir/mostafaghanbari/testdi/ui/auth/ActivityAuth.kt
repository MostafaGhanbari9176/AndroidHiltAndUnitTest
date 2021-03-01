package ir.mostafaghanbari.testdi.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ir.mostafaghanbari.testdi.R

/**
 * ## Host Of [FragmentLogIn] And [FragmentLogUp]
 *
 * we using AndroidEntryPoint annotation because child fragment used this annotation
 */
@AndroidEntryPoint
class ActivityAuth:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }

}