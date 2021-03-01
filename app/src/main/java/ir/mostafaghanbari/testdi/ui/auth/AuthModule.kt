package ir.mostafaghanbari.testdi.ui.auth

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ir.mostafaghanbari.testdi.R

@Module
@InstallIn(FragmentComponent::class)
object AuthModule {

    @Provides
    fun provideNavController(act:Activity): NavHostController {
        return NavHostController(act)
    }

}