package ir.mostafaghanbari.testdi.presenter

import org.junit.Assert
import org.junit.Test

/**
 * local unit test for checking [AuthPresenter] functionality
 */
class AuthPresenterTest {

    @Test
    fun logInInputs() {
        //check for invalid username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logIn("12345", "mos123")

        //check for invalid pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logIn("mostafa", "mos123")

        //check for empty username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logIn("", "1234")

        //check for short pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logIn("mostafa", "12")

        //check for correct data
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(ok)
            }
        }).logIn("mostafa", "123456")
    }

    @Test
    fun logUpInputs(){
        //check for invalid username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logUp("12345", "mos123")

        //check for invalid pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logUp("mostafa", "mos123")

        //check for empty username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logUp("", "1234")

        //check for short pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }).logUp("mostafa", "12")

        //check for correct data
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(ok)
            }
        }).logUp("mostafa", "123456")
    }

}