package com.andreadev.roomsample.route

import android.support.v4.app.Fragment
import com.andreadev.roomsample.ui.itemslist.ItemListActivity


/**
 * Created by andrea on 18/08/2017.
 */
class RouteManager {

    companion object Instance{

        fun itemList(fragment: Fragment) {
            val intent = ItemListActivity.getIntent(fragment.activity!!)
            fragment.startActivity(intent)
        }

    }
}