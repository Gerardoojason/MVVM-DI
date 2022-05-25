package id.ac.umn.app.mvvm_di.di


//import id.ac.umn.app.mvvm_di.BuildConfig
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import org.koin.core.module.dsl.singleOf
//import org.koin.dsl.module
//import retrofit2.Retrofit
//import id.ac.umn.app.mvvm_di.data.service.ApiHelper
//import id.ac.umn.app.mvvm_di.data.service.ApiService
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//val appModule = module {
//    single {
//        HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//    }
//    single {
//        OkHttpClient.Builder()
//            .addInterceptor(get<HttpLoggingInterceptor>())
//            .build()
//    }
//    single {
//        Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(get())
//    }
//    single {
//        get<Retrofit>().create(ApiService::class.java)
//    }
//    singleOf(::ApiHelper)
//}