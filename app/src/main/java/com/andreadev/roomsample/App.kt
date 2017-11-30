package com.andreadev.roomsample

import android.support.multidex.MultiDexApplication
import com.andreadev.roomsample.di.components.AppComponent
import com.andreadev.roomsample.di.components.DaggerAppComponent
import com.andreadev.roomsample.di.modules.*

/**
 * Created by andrea on 26/08/2017.
 */
class App : MultiDexApplication() {

    companion object {
        @JvmStatic lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        component.inject(this)
    }



}