package com.andreadev.roomsample.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.andreadev.roomsample.ui.base.activity.BaseActivity
import com.andreadev.roomsample.ui.itemslist.ItemListFragment
import com.andreadev.roomsample.utils.UiUtils

/**
 * Created by andrea on 18/08/2017.
 */
abstract class BaseMvpFragment<in V : BaseMvpView, T : BasePresenter<V>> : Fragment(), BaseMvpView {

    protected val TAG = ItemListFragment::class.java.simpleName

    protected lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = instancePresenter()
        mPresenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    override fun isAttached(): Boolean {
        return isAdded
    }

    protected abstract fun instancePresenter(): T

    override fun showError(errorMessage: String?) {
        if(isAttached()){
            UiUtils.showError(activity as BaseActivity, errorMessage!!)
        }
    }

    override fun showError(throwable: Throwable) {
        if(isAttached()){
            UiUtils.showError(activity as BaseActivity, throwable)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        if(isAttached()){
            (activity as BaseActivity).showLoading()
        }
    }

    override fun hideLoading() {
        if(isAttached()){
            (activity as BaseActivity).hideLoading()
        }
    }
}