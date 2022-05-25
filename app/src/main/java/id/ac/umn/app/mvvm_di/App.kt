package id.ac.umn.app.mvvm_di

import android.app.Application
import id.ac.umn.app.mvvm_di.di.appModule
import id.ac.umn.app.mvvm_di.di.repositoryModule
import id.ac.umn.app.mvvm_di.di.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }
}