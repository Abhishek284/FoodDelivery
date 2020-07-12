package com.lib.licious

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.lib.licious.adapter.FilterAdapter
import com.lib.licious.adapter.MenuDataAdapter
import com.lib.licious.listener.OnItemClickListener
import com.lib.licious.model.FilterDataModel
import com.lib.licious.model.MenuDataModel
import com.lib.licious.viewmodel.MenuListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private var hashMap: HashMap<String, List<MenuDataModel>> = HashMap()
    private var currentType: String = ""


    private val viewModel by inject<MenuListViewModel>()
    private var menuAdapter: MenuDataAdapter? = null
    private var filterAdapter: FilterAdapter? = null
    private val menuListObserver: Observer<List<MenuDataModel>> = Observer {
        menuAdapter = MenuDataAdapter(it)
        recyclerViewMenu.adapter = menuAdapter
        hashMap.put(currentType, it)
    }

    private val filterListObserver: Observer<List<FilterDataModel>> = Observer {
        filterAdapter = FilterAdapter(it, this)
        recyclerViewFilter.adapter = filterAdapter
        it.forEach {
            if (it.isSelected)
                currentType = it.type
        }
        viewModel.dataModelList.observe(this, menuListObserver)
        viewModel.getProductDataList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        backImage.setOnClickListener {
            onBackPressed()
        }

        val gridLayoutManagerMenu = GridLayoutManager(this, 2)
        recyclerViewMenu.layoutManager = gridLayoutManagerMenu

        val gridLayoutManagerFilter = GridLayoutManager(this, 2)
        recyclerViewFilter.layoutManager = gridLayoutManagerFilter

        viewModel.filterList.observe(this, filterListObserver)
        viewModel.getFilterList()

        setHeader(viewModel.getHeader())
    }

    override fun onItemClicked(type: String) {
        currentType = type
        if (hashMap.get(currentType) == null)
            viewModel.getFilteredMenuList(type)
        else {
            menuAdapter?.setMenuList(hashMap.get(currentType))
            menuAdapter?.notifyDataSetChanged()
        }

    }

    private fun setHeader(text: String?) {
        titleText.setText(text)
    }
}