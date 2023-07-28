package com.fftools.youtube.repositories.retrofit

import com.fftools.youtube.model.listcategory.Category
import com.fftools.youtube.untilities.Constant


class RetrofitRepositoryImpl(private val retrofitService: RetrofitService) {

    suspend fun getCategories(
        part: String,
        regionCode: String,
        key: String = Constant.apiKey
    ): Category {
        return retrofitService.getCategories(part, regionCode, key)
    }



}