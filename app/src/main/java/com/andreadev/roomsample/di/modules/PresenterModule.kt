package com.andreadev.roomsample.di.modules

import com.andreadev.roomsample.data.repository.RoomRepository
import com.andreadev.roomsample.di.PresenterScope
import com.andreadev.roomsample.ui.itemslist.ItemListPresenter
import com.andreadev.roomsample.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by andrea on 12/11/2017.
 */
@PresenterScope
@Module
class PresenterModule {

    @Provides
    fun provideSplashPresenter(): SplashPresenter = SplashPresenter()

    @Provides
    fun provideItemListPresenter(roomRepository: RoomRepository): ItemListPresenter = ItemListPresenter(roomRepository)
}