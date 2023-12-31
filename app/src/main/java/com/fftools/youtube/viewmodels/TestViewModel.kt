package com.fftools.youtube.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fftools.youtube.repositories.TestRepository
import com.fftools.youtube.untilities.Coroutines

class TestViewModel(
    private val testRepository: TestRepository
) : ViewModel() {
    private val testDataState = MutableLiveData<TestDataState>()
    val testUIDataSate: LiveData<TestDataState> get() = testDataState

    fun getData(a: Int, b: Int) {
        Coroutines.io {
            runCatching {
                emitTestDataState(isLoading = true)
                testRepository.test(a,b)
            }.onSuccess { result ->
                emitTestDataState(result = result)
            }.onFailure { error ->
                emitTestDataState(error = error.message.toString())
            }
        }
    }

    private fun emitTestDataState(
        isLoading: Boolean = false,
        result: Int? = null,
        error: String? = null
    ) {
        val dataState = TestDataState(isLoading, result, error)
        testDataState.postValue(dataState)
    }

    data class TestDataState(
        val isLoading: Boolean = false,
        val result: Int? = null,
        val error: String? = null
    )
}