package id.ac.umn.app.mvvm_di.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ac.umn.app.mvvm_di.MainActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun  mvvmMainActivity():MainActivity
}