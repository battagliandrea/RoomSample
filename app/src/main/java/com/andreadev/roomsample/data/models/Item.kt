package com.andreadev.roomsample.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Created by andrea on 12/11/2017.
 */
@Entity (tableName = "items")
class Item(
        @PrimaryKey var id: String,
        var name: String?,
        var active : Boolean
){

    constructor() : this("", "", false)
}