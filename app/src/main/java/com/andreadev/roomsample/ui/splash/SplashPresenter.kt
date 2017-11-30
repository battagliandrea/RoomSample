package com.andreadev.roomsample.ui.splash

import com.andreadev.roomsample.ui.base.BaseMvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by andrea on 16/08/2017.
 */
class SplashPresenter() : BaseMvpPresenter<SplashView>() {

    private val TAG = SplashPresenter::class.java.simpleName

    fun resume(){
       Observable.just(Unit)
               .delay(2000, TimeUnit.MILLISECONDS)
               .subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(
                       {u -> getView()?.navigateToItemListView() },
                       {t: Throwable ->  getView()?.showError("Error: " + t.message)})
    }



}