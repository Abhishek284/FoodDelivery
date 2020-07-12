package com.lib.licious

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_meat_product.view.*

class MenuDataAdapter(private val menuDataModelList: List<MenuDataModel>?) : RecyclerView.Adapter<MenuDataAdapter.MenuViewHolder>() {

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
            weightText.text = String.format("%s %s","Net wt." + menuDataModelList?.get(position)?.weight)
            Glide.with(this).load(menuDataModelList?.get(position)?.imageUrl).centerCrop().placeholder(R.drawable.placeholder_food).into(meatImage)
        }
    }

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}