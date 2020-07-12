package com.lib.licious.module

import com.lib.licious.mapper.DataMapper
import com.lib.licious.viewmodel.MenuListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { DataMapper(get()) }
    viewModel { MenuListViewModel(get()) }
}