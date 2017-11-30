package com.andreadev.roomsample.di.modules

import android.content.Context
import com.andreadev.roomsample.App
import com.andreadev.roomsample.di.AppContext
import dagger.Module
import dagger.Provides

/**
 * Created by andrea on 26/08/2017.
 */


@Module
open class AppModule(val app: App) {

    @Provides
    fun provideApp() : App {
        return app
    }

    @Provides
    @AppContext
    fun provideContext(): Context {
        return app
    }

}