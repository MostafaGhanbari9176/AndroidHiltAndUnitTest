package ir.mostafaghanbari.testdi.model

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * ## Test DB Functionality On Android Device
 *
 * recommended testing db on device instead of local machine
 * because the version of SQLite running on your device—and your users' devices—might
 * not match the version on your local machine
 */
@RunWith(AndroidJUnit4::class)
class UsersDaoTest {

    lateinit var db: RoomDB
    lateinit var usersDao: UsersDao

    @Before
    fun createDB() {
        val ctx = ApplicationProvider.getApplicationContext<Context>()
        //create temporary db
        db = Room.inMemoryDatabaseBuilder(ctx, RoomDB::class.java).build()
        usersDao = db.usersDao()
    }

    @Test
    fun checkQueries() {
        val user = User("mostafa", "123456")

        //insert user
        usersDao.insert(user)

        //check queries
        assert(usersDao.exist(user.name))
        assert(usersDao.exist(user.name, user.pass))
    }

    @After
    fun closeDb() {
        db.close()
    }

}