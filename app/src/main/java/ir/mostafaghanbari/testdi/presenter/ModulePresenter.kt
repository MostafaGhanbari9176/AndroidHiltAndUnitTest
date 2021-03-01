package ir.mostafaghanbari.testdi.presenter

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * ## Hilt Module For Providing CallBack Interfaces
 */
@Module
@InstallIn(FragmentComponent::class)
object ModulePresenter {

    /**
     * inject [AuthCallBack] to [AuthPresenter] instance
     * on every fragments that implemented [AuthCallBack] and need [AuthPresenter] instance
     *
     * @param [fragment] fragment that implemented [AuthCallBack]
     * @return implementation of [AuthCallBack] in [fragment]
     */
    @Provides
    fun bindAuthCallBack(fragment: Fragment): AuthCallBack =
        fragment as AuthCallBack

}