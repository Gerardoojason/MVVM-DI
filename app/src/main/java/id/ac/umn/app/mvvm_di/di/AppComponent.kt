package id.ac.umn.app.mvvm_di.di

import android.app.Application
import id.ac.umn.app.mvvm_di.App

//@Singleton
//@Component(
//    modules = [
//        AndroidInjectionModule::class,
//        RepositoryModule::class,
//        ActivityModule::class,
//        ViewModelModule::class,
//        NetworkModule::class,
//    ]
//)
//
//interface AppComponent: AndroidInjector<App>{
//    @Component.Builder
//    interface Builder{
//        @BindsInstance
//        fun application(application: Application):Builder
//        fun build():AppComponent
//    }
//    override fun inject(baseApplication: App)
//}