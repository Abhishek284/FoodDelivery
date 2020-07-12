package com.lib.licious

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { DataMapper(get()) }
    viewModel { MenuListViewModel(get()) }
}