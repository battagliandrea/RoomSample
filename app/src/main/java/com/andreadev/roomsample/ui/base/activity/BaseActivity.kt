package com.andreadev.roomsample.ui.base.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.andreadev.roomsample.R
import com.andreadev.roomsample.ui.widget.ProgressFragment

/**
 * Created by andrea on 16/08/2017.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment, "ROOT FRAGMENT").commit()
    }

    fun showLoading(){
        supportFragmentManager.beginTransaction().add(R.id.frame_container, ProgressFragment(), "progress_fragment").commit()
    }

    fun hideLoading(){
        supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentByTag("progress_fragment")).commit()
    }
}
