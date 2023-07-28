package com.fftools.youtube.viewmodels

import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fftools.youtube.model.listcategory.Category
import com.fftools.youtube.repositories.retrofit.RetrofitRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RetrofitModel(
    private val repository: RetrofitRepositoryImpl
) : ViewModel() {

    private val categoryDataState = MutableLiveData<CategoryDataState>()
    val categoryUIDataSate: LiveData<CategoryDataState> get() = categoryDataState


    fun getCategories(path: String, regionCode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                emitCategoryDataState(isLoading = true)
                repository.getCategories(path, regionCode)
            }.onSuccess {
                emitCategoryDataState(result = it)
            }.onFailure {
                emitCategoryDataState(error = it.message.toString())
            }
        }
    }

    private fun emitCategoryDataState(
        isLoading: Boolean = false,
        result: Category? = null,
        error: String? = null
    ) {
        val dataState = CategoryDataState(isLoading, result, error)
        categoryDataState.postValue(dataState)
    }

    data class CategoryDataState(
        val isLoading: Boolean = false,
        val result: Category? = null,
        val error: String? = null
    )
}