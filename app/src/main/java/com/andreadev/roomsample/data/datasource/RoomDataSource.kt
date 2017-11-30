package com.andreadev.roomsample.data.datasource

import android.arch.persistence.room.*
import com.andreadev.roomsample.data.models.Item
import io.reactivex.Flowable

/**
 * Created by andrea on 12/11/2017.
 */

@Dao
interface RoomDataSource {

    @Query("SELECT * FROM items")
    fun getAllItems(): Flowable<List<Item>>

    @Insert
    fun insert(item: Item) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(items: List<Item>) : List<Long>

    @Query("DELETE FROM items WHERE id IN(:itemId)")
    fun deleteItemById(itemId: Array<String>)

}