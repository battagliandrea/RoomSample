package com.andreadev.roomsample.di.components

import com.andreadev.roomsample.di.PresenterScope
import com.andreadev.roomsample.di.modules.PresenterModule
import com.andreadev.roomsample.ui.itemslist.ItemListFragment
import com.andreadev.roomsample.ui.splash.SplashFragment
import dagger.Component

/**
 * Created by andrea on 26/08/2017.
 */

@PresenterScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(PresenterModule::class))
interface PresenterComponent {

    fun inject(splashFragment: SplashFragment)

    fun inject(itemListFragment: ItemListFragment)

}