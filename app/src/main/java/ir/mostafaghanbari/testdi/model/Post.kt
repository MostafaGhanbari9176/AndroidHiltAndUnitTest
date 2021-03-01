package ir.mostafaghanbari.testdi.model

import androidx.room.*

/**
 * ## Post Entity
 *
 * @param [id] unique id of post
 * @param [username] post owner
 * @param [title] title of post
 * @param [message] message of post
 */
@Entity(tableName = "Posts")
data class Post(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var username: String = "",
    var title: String = "",
    var message: String = ""
)

@Dao
interface PostsDao{

    @Insert
    fun insert(post:Post):Long

    @Query("select * from Posts")
    fun posts():List<Post>

}