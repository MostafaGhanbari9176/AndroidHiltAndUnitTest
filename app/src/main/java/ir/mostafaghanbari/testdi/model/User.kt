package ir.mostafaghanbari.testdi.model

import androidx.room.*


/**
 * ## User Entity
 *
 * @param [name] username
 * @param [pass] user password
 */
@Entity(tableName = "Users")
data class User(
    @PrimaryKey var name: String = "",
    var pass: String = ""
)

@Dao
interface UsersDao {

    @Insert
    fun insert(user: User): Long

    @Query("select (count(*) != 0) as exist from Users where name = :name and pass = :pass")
    fun exist(name: String, pass: String):Boolean

    @Query("select (count(*) != 0) as exist from Users where name = :name")
    fun exist(name: String):Boolean

}