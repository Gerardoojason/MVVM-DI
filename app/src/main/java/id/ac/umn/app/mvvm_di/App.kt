package id.ac.umn.app.mvvm_di

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication




class App : DaggerApplication() {
    private val injector = DaggerAppComponent
        .builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return injector
    }
}