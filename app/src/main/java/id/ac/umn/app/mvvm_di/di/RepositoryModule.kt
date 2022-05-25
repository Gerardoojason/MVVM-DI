package id.ac.umn.app.mvvm_di.di

import dagger.Module
import dagger.Provides

import id.ac.umn.app.mvvm_di.data.Repository
import id.ac.umn.app.mvvm_di.data.service.ApiHelper

import javax.inject.Singleton

object RepositoryModule{
    @Singleton
    @Provides
    fun provideRepository(apiHelper: ApiHelper):Repository{
        return Repository(apiHelper)
    }
}

