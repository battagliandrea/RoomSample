package com.andreadev.roomsample.ui.base

/**
 * Created by andrea on 18/08/2017.
 */
interface BasePresenter<in V : BaseMvpView> {

    fun attachView(view: V)
    fun detachView()
}