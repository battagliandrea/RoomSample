package com.andreadev.roomsample.ui.itemslist

import com.andreadev.roomsample.data.models.Item
import com.andreadev.roomsample.ui.base.BaseMvpView

/**
 * Created by andrea on 18/08/2017.
 */
interface ItemListView : BaseMvpView {

    fun rootListSuccess(data : List<Item>)

    fun addItemSuccess(item: Item)
    fun deleteItemSuccess(position: Int, item: Item)
}