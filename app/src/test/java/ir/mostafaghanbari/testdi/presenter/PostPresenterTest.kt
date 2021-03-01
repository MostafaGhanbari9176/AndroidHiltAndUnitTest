package ir.mostafaghanbari.testdi.presenter

import ir.mostafaghanbari.testdi.model.Post
import ir.mostafaghanbari.testdi.model.PostsDao
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * local unit test for checking [PostPresenter] functionality
 */
@RunWith(MockitoJUnitRunner::class)
class PostPresenterTest {

    //mocking postsDao functionality to test presenter independent of database functionality
    @Mock
    private lateinit var postsDao: PostsDao

    @Test
    fun addPost() {

        //check invalid inputs
        PostPresenter(object : PresenterCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(!ok)
            }
        }, postsDao, Post()).createPost("", "", "")

        //check valid inputs
        PostPresenter(object : PresenterCallBack {
            override fun result(ok: Boolean, message: String) {
                assert(ok)
            }
        }, postsDao, Post()).createPost("title", "message", "mostafa")
    }

}