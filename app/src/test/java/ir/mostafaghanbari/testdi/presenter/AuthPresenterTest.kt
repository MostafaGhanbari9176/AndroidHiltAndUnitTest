package ir.mostafaghanbari.testdi.presenter

import ir.mostafaghanbari.testdi.model.User
import ir.mostafaghanbari.testdi.model.UsersDao
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * local unit test for checking [AuthPresenter] functionality
 */
@RunWith(MockitoJUnitRunner::class)
class AuthPresenterTest {

    //mocking userDao functionality to test presenter independent of database functionality
    @Mock
    private lateinit var usersDao: UsersDao

    @Test
    fun logInInputs() {

        //configure exist method of mock object
        `when`(usersDao.exist(anyString(), anyString()))
            .thenReturn(true)

        //check for invalid username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logIn("12345", "mos123")

        //check for invalid pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logIn("mostafa", "mos123")

        //check for empty username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logIn("", "1234")

        //check for short pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logIn("mostafa", "12")

        //check for correct data
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(ok)
            }
        }, usersDao, User()).logIn("mostafa", "123456")
    }

    @Test
    fun logUpInputs() {
        //configure exist method of mock object
        `when`(usersDao.exist(anyString()))
            .thenReturn(false)

        //check for invalid username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logUp("12345", "mos123")

        //check for invalid pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logUp("mostafa", "mos123")

        //check for empty username
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logUp("", "1234")

        //check for short pass
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, usersDao, User()).logUp("mostafa", "12")

        //check for correct data
        AuthPresenter(object : AuthCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(ok)
            }
        }, usersDao, User()).logUp("mostafa", "123456")
    }

}