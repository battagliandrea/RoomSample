package com.andreadev.roomsample.di.components

import android.content.Context
import com.andreadev.roomsample.App
import com.andreadev.roomsample.data.database.RoomSampleDatabase
import com.andreadev.roomsample.data.datasource.RoomDataSource
import com.andreadev.roomsample.di.AppContext
import com.andreadev.roomsample.di.modules.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by andrea on 26/08/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {

    fun inject(app: App)

    @AppContext
    fun context(): Context
    fun app(): App

    fun itemsDataSouce(): RoomDataSource
    fun roomSampleDatabase(): RoomSampleDatabase
}