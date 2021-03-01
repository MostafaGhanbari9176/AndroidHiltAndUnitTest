package ir.mostafaghanbari.testdi.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Post::class], version = 1)
abstract class RoomDB:RoomDatabase() {

    abstract fun postsDao(): PostsDao

    abstract fun usersDao(): UsersDao
}