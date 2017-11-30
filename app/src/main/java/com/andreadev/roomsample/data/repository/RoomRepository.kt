package com.andreadev.roomsample.data.repository

import com.andreadev.roomsample.data.datasource.RoomDataSource
import com.andreadev.roomsample.data.models.Item
import io.reactivex.Observable
import javax.inject.Inject

class RoomRepository @Inject constructor(roomDataSource: RoomDataSource){

    private var roomDataSource: RoomDataSource = roomDataSource

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  ITEM
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun itemsList(): Observable<List<Item>> = roomDataSource.getAllItems().firstElement().toObservable()

    fun insertItem(item: Item) : Observable<Long> = Observable.just(roomDataSource.insert(item))

    fun insertItemsList(items: List<Item>) : Observable<List<Long>> = Observable.just(roomDataSource.insertList(items))

    fun deleteItem(itemId: String) = roomDataSource.deleteItemById(arrayOf(itemId))

}