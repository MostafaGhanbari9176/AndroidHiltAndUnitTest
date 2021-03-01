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

@RunWith(AndroidJUnit4::class)
class PostDaoTest {

    private lateinit var db: RoomDB
    private lateinit var postsDao: PostsDao

    @Before
    fun createDB() {
        val ctx = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(ctx, RoomDB::class.java).build()

        postsDao = db.postsDao()
    }

    @Test
    fun checkQueries() {
        val post = Post(
            username = "mostafa",
            title = "title",
            message = "message"
        )

        postsDao.insert(post)

        val posts = postsDao.posts()

        Assert.assertEquals(posts.size, 1)
        Assert.assertEquals(posts[0].username, "mostafa")
        Assert.assertEquals(posts[0].title, "title")
        Assert.assertEquals(posts[0].message, "message")
        Assert.assertEquals(posts[0].id, 1)

    }

    @After
    fun closeDB() {
        db.close()
    }
}