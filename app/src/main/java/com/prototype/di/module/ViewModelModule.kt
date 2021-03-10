package com.prototype.di.module

import com.prototype.ui.main.viewmodel.DetailViewModel
import com.prototype.ui.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
    viewModel { DetailViewModel() }
}