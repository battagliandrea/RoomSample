package com.andreadev.roomsample.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.andreadev.roomsample.data.datasource.RoomDataSource
import com.andreadev.roomsample.data.models.Item

/**
 * Created by andrea on 12/11/2017.
 */
@Database(entities = arrayOf(Item::class), version = RoomSampleDatabase.DATABASE_VERSION, exportSchema = false)
abstract class RoomSampleDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION : Int = 1
    }

    abstract fun itemDataSource(): RoomDataSource
}