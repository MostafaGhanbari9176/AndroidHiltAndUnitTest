package ir.mostafaghanbari.testdi.presenter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.mostafaghanbari.testdi.model.*

/**
 * ## Hilt Module For Providing CallBack Interfaces
 */
@Module
@InstallIn(FragmentComponent::class)
object PresenterModule {

    /**
     * inject [PresenterCallBack] to [AuthPresenter] instance
     * on every fragments that implemented [PresenterCallBack] and need [AuthPresenter] instance
     *
     * @param [fragment] fragment that implemented [PresenterCallBack]
     * @return implementation of [PresenterCallBack] in [fragment]
     */
    @Provides
    fun bindPresenterCallBack(fragment: Fragment): PresenterCallBack =
        fragment as PresenterCallBack

    /**
     * its provide [RoomDB] instance every where need to inject [RoomDB]
     *
     * @param [ctx] application context from hilt default qualifiers
     *
     * Singleton annotation tells Hilt that instance should be created only once
     */
    @Provides
    fun provideDB(@ApplicationContext ctx: Context): RoomDB {
        return Room.databaseBuilder(ctx, RoomDB::class.java, "TestDI")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * its provide [UsersDao] instance every where need to inject [UsersDao]
     *
     * @param [db] application database
     */
    @Provides
    fun provideUsersDao(db: RoomDB): UsersDao {
        return db.usersDao()
    }

    @Provides
    fun provideUser():User = User()

    @Provides
    fun providePostsDao(db:RoomDB):PostsDao{
        return db.postsDao()
    }

    @Provides
    fun providePost(): Post = Post()

}