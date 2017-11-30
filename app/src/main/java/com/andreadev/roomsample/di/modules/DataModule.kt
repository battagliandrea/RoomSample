package com.andreadev.roomsample.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.andreadev.roomsample.App
import com.andreadev.roomsample.data.database.RoomSampleDatabase
import com.andreadev.roomsample.di.AppContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.arch.persistence.room.Room
import com.andreadev.roomsample.data.datasource.RoomDataSource


/**
 * Created by andrea on 26/08/2017.
 */
@Module
open class DataModule {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                              ROOM
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Singleton
    @Provides
    fun providesRoomSampleDatabase(app: App): RoomSampleDatabase {
        return Room.databaseBuilder(app, RoomSampleDatabase::class.java, "roomsample-db").allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun providesRoomSampleDataSource(demoDatabase: RoomSampleDatabase): RoomDataSource {
        return demoDatabase.itemDataSource()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                         SHARED PREFERENCES
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Provides
    @Singleton
    fun provideSharedPreferences(@AppContext context: Context): SharedPreferences {
        return context.getSharedPreferences("roomsample-prefs", Context.MODE_PRIVATE)
    }


}