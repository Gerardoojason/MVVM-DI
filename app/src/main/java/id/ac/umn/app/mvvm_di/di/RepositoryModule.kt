package id.ac.umn.app.mvvm_di.di

import id.ac.umn.app.mvvm_di.Repository
import org.koin.dsl.module

val repositoryModule = module{
    single{
        Repository(get())
    }
}

