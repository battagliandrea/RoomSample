package com.andreadev.roomsample.ui.base.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.andreadev.roomsample.R

/**
 * Created by andrea on 14/09/2017.
 */
open class BaseToolbarActivity : BaseActivity() {

    private lateinit var toolBarView : View
    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolBarView = layoutInflater.inflate(R.layout.toolbar, null)

        toolbar = toolBarView.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val rootView = findViewById<FrameLayout> (R.id.main_container) as FrameLayout
        val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.TOP
        rootView.addView(toolBarView, params)
    }
}