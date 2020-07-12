package com.lib.licious.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lib.licious.model.FilterDataModel
import com.lib.licious.R
import com.lib.licious.listener.OnItemClickListener
import kotlinx.android.synthetic.main.item_filter.view.*

class FilterAdapter(private val filterModelList: List<FilterDataModel>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {

    private val TYPE_ALL = "all"
    private val TYPE_EXPRESS = "express"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter, parent, false)
        return FilterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filterModelList.size ?: 0
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.itemView.run {
            if (filterModelList.get(position).isSelected) {
                deliveryTypeButton.background = ContextCompat.getDrawable(deliveryTypeButton.context, R.drawable.bg_filter_button_enabled)
                deliveryTypeText.setTextColor(ContextCompat.getColor(deliveryTypeButton.context, R.color.colorWhite))
            } else {
                deliveryTypeButton.background = ContextCompat.getDrawable(deliveryTypeButton.context, R.drawable.bg_filter_button_disabled)
                deliveryTypeText.setTextColor(ContextCompat.getColor(deliveryTypeButton.context, R.color.colorGreyFilter))
            }
            deliveryTypeText.text = filterModelList.get(position).name
            deliveryTypeButton.setOnClickListener {
                filterModelList.forEach {
                    it.isSelected = false
                }
                filterModelList.get(position).isSelected = true
                onItemClickListener.onItemClicked(filterModelList.get(position).type)
                notifyDataSetChanged()
            }
        }
    }

    class FilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}