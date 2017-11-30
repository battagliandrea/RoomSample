package com.andreadev.roomsample.ui.splash

import android.os.Bundle
import com.andreadev.roomsample.ui.base.activity.BaseActivity

class SplashActivity :BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(SplashFragment.newIstance())
    }
}
