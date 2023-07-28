package com.fftools.youtube.dependencyinjection

import com.fftools.youtube.viewmodels.RetrofitModel
import com.fftools.youtube.viewmodels.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TestViewModel(testRepository = get()) }
    viewModel {RetrofitModel(get())}
}