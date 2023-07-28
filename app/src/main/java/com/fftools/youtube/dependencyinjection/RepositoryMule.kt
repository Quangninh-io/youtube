package com.fftools.youtube.dependencyinjection


import com.fftools.youtube.repositories.retrofit.RetrofitClient
import com.fftools.youtube.repositories.retrofit.RetrofitService
import com.fftools.youtube.repositories.TestRepository
import com.fftools.youtube.repositories.TestRepositoryImpl
import com.fftools.youtube.repositories.retrofit.RetrofitRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule = module {
    factory<TestRepository> { TestRepositoryImpl(androidContext()) }

    single { RetrofitClient.create(RetrofitService::class.java) }
    single { RetrofitRepositoryImpl(get()) }
}


