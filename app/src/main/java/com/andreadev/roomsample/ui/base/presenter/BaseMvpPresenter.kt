package com.andreadev.roomsample.ui.base

/**
 * Created by andrea on 18/08/2017.
 */
open class BaseMvpPresenter<V : BaseMvpView> : BasePresenter<V> {

    protected var mView : V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

    fun getView() : V?{
        return mView
    }

    fun customError(throwable: Throwable){
        //var message = Gson().fromJson(throwable.message, ErrorMessage::class.java)
        mView?.showError(throwable)
    }
}