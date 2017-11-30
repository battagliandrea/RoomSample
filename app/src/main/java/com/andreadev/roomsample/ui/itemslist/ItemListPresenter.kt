package com.andreadev.roomsample.ui.itemslist

import com.andreadev.roomsample.data.models.Item
import com.andreadev.roomsample.data.repository.RoomRepository
import com.andreadev.roomsample.ui.base.BaseMvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by andrea on 16/08/2017.
 */
class ItemListPresenter(val roomRepository: RoomRepository) : BaseMvpPresenter<ItemListView>() {

    private val TAG = ItemListPresenter::class.java.simpleName

    fun getList() {
        mView?.showLoading()
        roomRepository.itemsList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { data ->
                            getView()?.rootListSuccess(data)
                            mView?.hideLoading()
                        },
                        { error ->
                            error.printStackTrace()
                            customError(error)
                            mView?.hideLoading()
                        })
    }

    fun addItem(item: Item) {
        mView?.showLoading()
        roomRepository.insertItem(item)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { long ->
                        if(long>0){
                            getView()?.addItemSuccess(item)
                            mView?.hideLoading()
                        }
                    },
                    { error ->
                        error.printStackTrace()
                        customError(error)
                        mView?.hideLoading()
                    })
    }

    fun deleteItem(position: Int, item: Item) {
        mView?.showLoading()
        Observable.just(roomRepository.deleteItem(item.id))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { data ->
                            getView()?.deleteItemSuccess(position, item)
                            mView?.hideLoading()
                        },
                        { error ->
                            error.printStackTrace()
                            customError(error)
                            mView?.hideLoading()
                        })
    }
}