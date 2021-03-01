package ir.mostafaghanbari.testdi.ui.auth

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.mostafaghanbari.testdi.R
import ir.mostafaghanbari.testdi.presenter.PresenterCallBack
import ir.mostafaghanbari.testdi.presenter.AuthPresenter
import kotlinx.android.synthetic.main.fragment_logup.*
import javax.inject.Inject

/**
 * ## LogUp Form
 *
 * with AndroidEntryPoint annotation hilt can provide this dependencies in fact
 * this annotation create a dagger component of required dependencies and then
 * we using Inject annotation on field deceleration for injecting dependencies
 */
@AndroidEntryPoint
class FragmentLogUp : Fragment(), PresenterCallBack {

    /**
     * using Inject annotation for injecting this dependency
     */
    @Inject lateinit var authPresenter:AuthPresenter


    /**
     * ActivityContext is a hilt default binding
     */
    @Inject
    @ActivityContext
    lateinit var ctx:Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        btnCreateAccount.setOnClickListener {
            logUp()
        }
    }

    private fun logUp() {
        val name = txtUserName.text.toString()
        val pass = txtPassword.text.toString()

        authPresenter.logUp(name, pass)
    }

    override fun result(ok: Boolean, message: String) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
        if (ok)
            (ctx as Activity).onBackPressed()
    }

}