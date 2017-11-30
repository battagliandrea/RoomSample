package com.andreadev.roomsample.ui.itemslist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreadev.roomsample.R
import com.andreadev.roomsample.data.models.Item
import com.andreadev.roomsample.ui.extensions.ctx
import kotlinx.android.synthetic.main.view_list_item.view.*

/**
 * Created by andrea on 14/09/2017.
 */
class ItemListAdapter(val context: Context?, val listener : OnItemActionListener) : RecyclerView.Adapter<ItemListAdapter.ViewHolder>(){

    private val mContext : Context? = context
    private val mListener : OnItemActionListener = listener
    private var items: MutableList<Item>

    init {
        items = ArrayList()
    }

    interface OnItemActionListener {
        fun onItemDeleteClick(position: Int, item: Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder = ViewHolder(LayoutInflater.from(parent.ctx).inflate(R.layout.view_list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    fun setData(items: List<Item>) {
        this.items = items as MutableList<Item>
        notifyDataSetChanged()
    }

    fun addItem(item: Item) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int, item: Item) {
        items.remove(item)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: Item) = with(itemView) {
            item_name_tv.text = item.name

            if(item.active){
                item_card.setBackgroundResource(R.drawable.selector_rectangle_orange)
                item_delete_iv.visibility = View.VISIBLE
            } else {
                item_card.setBackgroundResource(R.drawable.selector_rectangle_white)
                item_delete_iv.visibility = View.INVISIBLE
            }

            item_delete_iv.setOnClickListener {mListener.onItemDeleteClick(adapterPosition, items.get(adapterPosition))}

            itemView.setOnLongClickListener {view ->
                if(!items.get(adapterPosition).active){
                    items.get(adapterPosition).active = true
                    notifyItemChanged(adapterPosition)
                } else {
                    items.get(adapterPosition).active = false
                    notifyItemChanged(adapterPosition)
                }
                true
            }

        }
    }
}