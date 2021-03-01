package ir.mostafaghanbari.testdi.presenter

import ir.mostafaghanbari.testdi.model.Post
import ir.mostafaghanbari.testdi.model.PostsDao
import javax.inject.Inject

/**
 *## Functionality For Managing Posts
 *
 * using Inject annotation for telling hilt how provide instance of this and
 * what this dependencies
 *
 * @param [callBack] delivering result to view
 * @param [postsDao]
 * @param [post]
 */
class PostPresenter @Inject constructor(
    private val callBack: PresenterCallBack,
    private val postsDao: PostsDao,
    private val post: Post
) {

    /**
     * ### Create New Post
     *
     * @param [title] title of post
     * @param [message] message of post
     * @param [username] owner
     */
    fun createPost(
        title: String,
        message: String,
        username: String
    ) {
        val validate = validatePost(title, message)

        if (validate) {
            post.title = title.trim()
            post.message = message.trim()
            post.username = username.trim()

            postsDao.insert(post)

            callBack.result(true, "Post Created.")
        }

    }

    fun getPosts() {
        val posts = postsDao.posts()

        callBack.posts(posts)
    }

    /**
     * validate new post data
     *
     * @param [title] new post title
     * @param [message] new post message
     */
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