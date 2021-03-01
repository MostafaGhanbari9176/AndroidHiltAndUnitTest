package ir.mostafaghanbari.testdi.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.mostafaghanbari.testdi.R
import ir.mostafaghanbari.testdi.presenter.PresenterCallBack
import ir.mostafaghanbari.testdi.presenter.AuthPresenter
import ir.mostafaghanbari.testdi.ui.main.ActivityMain
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * ## LogIn Form
 */
@AndroidEntryPoint
class FragmentLogIn : Fragment(), PresenterCallBack {

    @Inject lateinit var authPresenter:AuthPresenter

    @ApplicationContext
    @Inject
    lateinit var ctx:Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        btnLogin.setOnClickListener {
            logIn()
        }

        btnCreateAccount.setOnClickListener {
            createAccountPage()
        }
    }

    private fun createAccountPage() {
        val action = FragmentLogInDirections.actionLogUp()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun logIn() {
        val name = txtUserName.text.toString()
        val pass = txtPassword.text.toString()

        authPresenter.logIn(name, pass)
    }

    override fun result(ok: Boolean, message: String) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
        if(ok)
            showMainPage()
    }

    private fun showMainPage() {
        val intent = Intent(ctx, ActivityMain::class.java)
        startActivity(intent)
    }

}