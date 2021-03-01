package ir.mostafaghanbari.testdi.presenter

import ir.mostafaghanbari.testdi.model.Post
import ir.mostafaghanbari.testdi.model.PostsDao
import javax.inject.Inject

class PostPresenter @Inject constructor(
    private val callBack: PresenterCallBack,
    private val postsDao: PostsDao,
    private val post: Post
) {

    fun createPost(
        title: String,
        message: String
    ) {
        val validate = validatePost(title, message)

        if (validate) {
            post.title = title.trim()
            post.message = message.trim()

            postsDao.insert(post)

            callBack.result(true, "Post Created.")
        }

    }

    fun getPosts() {
        val posts = postsDao.posts()

        callBack.posts(posts)
    }

    private fun validatePost(
        title: String,
        message: String
    ): Boolean {
        if (title.trim().isEmpty()) {
            callBack.result(false, "Title Is Empty")
            return false
        }

        if (message.trim().isEmpty()) {
            callBack.result(false, "Message Is Empty")
            return false
        }

        return true
    }

}