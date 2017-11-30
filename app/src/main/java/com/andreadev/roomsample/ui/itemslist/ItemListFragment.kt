package com.andreadev.roomsample.ui.itemslist

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.EditText
import com.andreadev.roomsample.App
import com.andreadev.roomsample.R
import com.andreadev.roomsample.data.models.Item
import com.andreadev.roomsample.di.components.DaggerPresenterComponent
import com.andreadev.roomsample.utils.UiUtils
import com.andreadev.roomsample.ui.base.BaseMvpFragment
import com.andreadev.roomsample.ui.base.activity.BaseActivity
import kotlinx.android.synthetic.main.fragment_item_list.*
import java.util.*
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class ItemListFragment : BaseMvpFragment<ItemListView, ItemListPresenter>(), ItemListView {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  INIT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var itemListPresenter: ItemListPresenter

    companion object Instance{
        fun newIstance(): ItemListFragment = ItemListFragment()
    }

    init {
        DaggerPresenterComponent.builder().appComponent(App.component).build().inject(this)
    }

    override fun instancePresenter(): ItemListPresenter = itemListPresenter


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  FRAGMENT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private lateinit var adapter : ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.getList()

        adapter = ItemListAdapter(context, mItemListener)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            R.id.menu_add -> showAddDialog()
        }
        return false
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  VIEW
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun rootListSuccess(data: List<Item>) {
        adapter.setData(data)
    }

    override fun addItemSuccess(item: Item) {
        adapter.addItem(item)
    }

    override fun deleteItemSuccess(position: Int, item: Item) {
        adapter.removeItem(position, item)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                              ADAPTER LISTENER
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private val mItemListener : ItemListAdapter.OnItemActionListener = object: ItemListAdapter.OnItemActionListener{
        override fun onItemDeleteClick(position: Int, item: Item){
            UiUtils.showAlert(
                    activity as BaseActivity, getString(R.string.remove_item_title),
                    getString(R.string.remove_item_text),
                    DialogInterface.OnClickListener { dialogInterface, i -> mPresenter.deleteItem(position, item) },
                    DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() }
                    )
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  ADD DIALOG
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private fun showAddDialog() {
        val inflater = activity?.getSystemService (Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflator = inflater.inflate(R.layout.view_add_dialog, null)

        var et : EditText = inflator.findViewById(R.id.et_item)

        val builder: AlertDialog.Builder = AlertDialog.Builder(ContextThemeWrapper(activity, R.style.AppTheme_AlertDialog))
        builder.setView(inflator)
        builder.setCancelable(false)

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->

            var item = Item(UUID.randomUUID().toString(), et.text.toString(), false)
            mPresenter.addItem(item)

            dialog.dismiss()
        }
        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }
}