package com.andreadev.roomsample.ui.base
/**
 * Created by andrea on 18/08/2017.
 */

interface BaseMvpView {

    fun isAttached() : Boolean

    fun showError(error: String?)
    fun showError(throwable: Throwable)
    fun showMessage(message: String)

    fun showLoading()
    fun hideLoading()
}