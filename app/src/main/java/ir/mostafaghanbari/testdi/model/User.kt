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

    /**
     * add new user to database
     *
     * @param[user] new user
     */
    @Insert
    fun insert(user: User): Long

    /**
     * can be used for logIn
     *
     * @param[name] username
     * @param[pass] user password
     *
     * @return if find a row base on [name] and [pass] then return true otherwise return false
     */
    @Query("select (count(*) != 0) as exist from Users where name == :name and pass == :pass")
    fun exist(name: String, pass: String): Boolean

    /**
     * @param[name] username
     *
     * @return if find a row base on [name] then return true otherwise return false
     */
    @Query("select (count(*) != 0) as exist from Users where name == :name")
    fun exist(name: String): Boolean

}