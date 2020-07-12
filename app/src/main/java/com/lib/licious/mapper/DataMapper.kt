package com.lib.licious.mapper

import LiciousDataResposne
import android.content.Context
import com.google.gson.Gson
import com.lib.licious.model.FilterDataModel
import com.lib.licious.model.MenuDataModel
import java.io.InputStream
import java.util.*


class DataMapper(private val context: Context) {

    companion object {
        const val TYPE_ALL = "all"
    }

    fun convertJsonToDataClass(): List<MenuDataModel> {
        val menuDataModelList = mutableListOf<MenuDataModel>()
        getResponseFromJson().data?.products?.forEach {
            menuDataModelList.add(MenuDataModel(it.productMerchantdising?.prImage, it.productMaster?.prName, it.productMaster?.prWeight, it.productPricing?.basePrice))
        }
        return menuDataModelList
    }

    fun convertJsonToFilterListClass(): List<FilterDataModel> {

        val filterDataModelList = mutableListOf<FilterDataModel>()
        getResponseFromJson().data?.filters?.forEach {
            filterDataModelList.add(FilterDataModel(it.type, it.title, false))
        }
        filterDataModelList.get(0).isSelected = true
        return filterDataModelList
    }

    fun getFilteredList(type: String): List<MenuDataModel> {

        if (type == TYPE_ALL) {
            return convertJsonToDataClass()
        }
        val filterdMenuList = mutableListOf<MenuDataModel>()
        getResponseFromJson().data?.products?.forEach {
            if (it.productMerchantdising?.productDeliveryType?.toLowerCase(Locale.getDefault()) == type)
                filterdMenuList.add(MenuDataModel(it.productMerchantdising?.prImage, it.productMaster?.prName, it.productMaster?.prWeight, it.productPricing?.basePrice))
        }
        return filterdMenuList
    }

    private fun getResponseFromJson(): LiciousDataResposne {
        val isStream: InputStream = context.assets.open("product_reorder.json")
        val size: Int = isStream.available()
        val buffer = ByteArray(size)
        isStream.read(buffer)
        isStream.close()
        val gson = Gson()
        val liciousDataResposne: LiciousDataResposne = gson.fromJson(String(buffer), LiciousDataResposne::class.java)
        return liciousDataResposne
    }

    fun getHeader(): String? {
        return getResponseFromJson().data?.title
    }
}