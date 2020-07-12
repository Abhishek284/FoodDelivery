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


    private val viewModel by inject<MenuListViewModel>()

    private val menuListObserver: Observer<List<MenuDataModel>> = Observer {
        val adapter = MenuDataAdapter(it)
        recyclerViewMenu.adapter = adapter
    }

    private val filterListObserver: Observer<List<FilterDataModel>> = Observer {
        val adapter = FilterAdapter(it, this)
        recyclerViewFilter.adapter = adapter
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
        viewModel.dataModelList.observe(this, menuListObserver)
        viewModel.getProductDataList()
        setHeader(viewModel.getHeader())
    }

    override fun onItemClicked(type: String) {
        viewModel.getFilteredMenuList(type)
    }

    private fun setHeader(text: String?) {
        titleText.setText(text)
    }
}