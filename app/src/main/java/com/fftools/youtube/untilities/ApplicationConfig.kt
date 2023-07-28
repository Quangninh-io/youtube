package com.fftools.youtube.untilities

import android.app.Application
import com.fftools.youtube.dependencyinjection.repositoryModule
import com.fftools.youtube.dependencyinjection.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationConfig : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationConfig)
            modules(listOf(repositoryModule,viewModelModule))
        }
    }

}