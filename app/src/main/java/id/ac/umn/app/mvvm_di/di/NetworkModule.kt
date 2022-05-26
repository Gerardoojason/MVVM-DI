package id.ac.umn.app.mvvm_di.di

import dagger.Module
import dagger.Provides

import id.ac.umn.app.mvvm_di.BuildConfig
import id.ac.umn.app.mvvm_di.data.service.ApiHelper
import id.ac.umn.app.mvvm_di.data.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    @Singleton
    @Provides
    fun provideOkHttp(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ):Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create()
    }
    @Singleton
    @Provides
    fun provideApiHelper(apiService: ApiService):ApiHelper{
        return ApiHelper(apiService)
    }
}