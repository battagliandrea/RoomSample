package com.andreadev.roomsample.ui.itemslist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.andreadev.roomsample.R
import com.andreadev.roomsample.ui.base.activity.BaseToolbarActivity

class ItemListActivity : BaseToolbarActivity() {

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, ItemListActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setTitle(getString(R.string.app_name))

        replaceFragment(ItemListFragment.newIstance())
    }
}
