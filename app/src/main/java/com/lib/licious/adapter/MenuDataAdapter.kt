package com.lib.licious.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lib.licious.R
import com.lib.licious.model.MenuDataModel
import kotlinx.android.synthetic.main.item_meat_product.view.*
import kotlinx.android.synthetic.main.layout_add_cart.view.*

class MenuDataAdapter(private var menuDataModelList: List<MenuDataModel>?, private val onItemCountExceedListener: OnItemCountExceedListener) : RecyclerView.Adapter<MenuDataAdapter.MenuViewHolder>() {

    fun setMenuList(menuDataModelList: List<MenuDataModel>?) {
        this.menuDataModelList = menuDataModelList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meat_product, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuDataModelList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.itemView.run {

            meatName.text = menuDataModelList?.get(position)?.name
            priceTxt.text = String.format("%s %d", "\u20B9", menuDataModelList?.get(position)?.price?.toInt())
            weightText.text = String.format("%s %s", "Net wt.", menuDataModelList?.get(position)?.weight)
            Glide.with(this).load(menuDataModelList?.get(position)?.imageUrl).centerCrop().placeholder(R.drawable.placeholder_food).into(meatImage)
            if (menuDataModelList?.get(position)?.count == 0) {
                addCartLayout.visibility = GONE
                addCartButton.visibility = VISIBLE
            } else {
                addCartLayout.visibility = VISIBLE
                addCartButton.visibility = GONE
                centerText.text = menuDataModelList?.get(position)?.count?.toString()
            }
            addCartButton.setOnClickListener {
                addCartLayout.visibility = VISIBLE
                addCartButton.visibility = GONE
                centerText.text = "1"
                menuDataModelList?.get(position)?.count = 1
            }

            plusTxt.setOnClickListener {
                val int = centerText.text.toString().toInt()
                menuDataModelList?.get(position)?.maxCount?.let {
                    if ((int + 1) > it) {
                        onItemCountExceedListener.onCountLimitExceeded()
                    } else {
                        centerText.text = (int + 1).toString()
                        menuDataModelList?.get(position)?.count = int + 1
                    }
                }
            }

            minusTxt.setOnClickListener {
                val int = centerText.text.toString().toInt()
                if (int > 1) {
                    centerText.text = (int - 1).toString()
                } else {
                    centerText.text = "1"
                    addCartLayout.visibility = GONE
                    addCartButton.visibility = VISIBLE
                }
                menuDataModelList?.get(position)?.count = int - 1
            }
        }
    }

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    interface OnItemCountExceedListener {
        fun onCountLimitExceeded()
    }

}