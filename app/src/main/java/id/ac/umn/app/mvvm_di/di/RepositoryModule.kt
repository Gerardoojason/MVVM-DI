package id.ac.umn.app.mvvm_di.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.ac.umn.app.mvvm_di.data.Repository
import id.ac.umn.app.mvvm_di.data.service.ApiHelper

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule{
    @ViewModelScoped
    @Provides
    fun provideRepository(apiHelper: ApiHelper) = Repository(apiHelper)
}
