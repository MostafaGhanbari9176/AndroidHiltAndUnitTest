package ir.mostafaghanbari.testdi.model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey

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
    val username: String,
    val title: String,
    val message: String
)

@Dao
interface PostsDao{

    @Insert
    fun insert(post:Post)

}