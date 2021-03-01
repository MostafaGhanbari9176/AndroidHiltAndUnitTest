package ir.mostafaghanbari.testdi.presenter

import androidx.core.text.isDigitsOnly
import javax.inject.Inject

class AuthPresenter @Inject constructor(
    private val callBack: AuthCallBack?
) {

    fun logIn(name: String, pass: String) {
        val validate = validate(name, pass)
        if (validate) {
            callBack?.result(true, "Your LogIn Is Success")
        }
    }

    fun logUp(name: String, pass: String) {
        val validate = validate(name, pass)
        if (validate) {
            callBack?.result(true, "Your Account Created")
        }
    }

    /**
     * ### validate name and pass
     *
     * @param [name] user name
     * @param[pass] user password
     *
     * @return true if:
     * - name not empty
     * - name not digit only
     * - pass digit only
     * - min length of pass => 4
     */
    private fun validate(name: String, pass: String): Boolean {
        if (name.trim().isEmpty()) {
            callBack?.result(false, "Name Is Empty")
            return false
        }
        if (name.trim().isDigitsOnly()) {
            callBack?.result(false, "Name Not Correct Cause Is Digit")
            return false
        }

        if (pass.trim().length < 4) {
            callBack?.result(false, "Min Length Of Pass => 4")
            return false
        }
        if (!(pass.trim().isDigitsOnly())) {
            callBack?.result(false, "Pass Must Be Only Digit")
            return false
        }

        return true
    }

}