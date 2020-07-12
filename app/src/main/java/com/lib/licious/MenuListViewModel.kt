package com.lib.licious

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers

class MenuListViewModel(private val dataMapper: DataMapper) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val menuDataModelList = MutableLiveData<List<MenuDataModel>>()
    val dataModelList: LiveData<List<MenuDataModel>>
        get() = menuDataModelList

    private val filterModelList = MutableLiveData<List<FilterDataModel>>()
    val filterList: LiveData<List<FilterDataModel>>
        get() = filterModelList


    fun getProductDataList() {
        val disposable = Observable.fromCallable { dataMapper.convertJsonToDataClass() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                menuDataModelList.postValue(it)
            })
        disposables.add(disposable)
    }

    fun getFilterList() {
        val disposable = Observable.fromCallable { dataMapper.convertJsonToFilterListClass() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                filterModelList.postValue(it)
            })
        disposables.add(disposable)
    }

    fun getFilteredMenuList(type: String){
        val disposable = Observable.fromCallable { dataMapper.getFilteredList(type) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                menuDataModelList.postValue(it)
            })
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getHeader(): String? {
        return dataMapper.getHeader()
    }
}