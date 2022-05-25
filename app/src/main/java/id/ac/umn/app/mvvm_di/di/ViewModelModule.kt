package id.ac.umn.app.mvvm_di.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import id.ac.umn.app.mvvm_di.MainActivityViewModel
import id.ac.umn.app.mvvm_di.ViewModelFactory
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMVVMMainViewModel(mainActivityViewModel: MainActivityViewModel):ViewModel
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory):ViewModelProvider.Factory
}
@Target(AnnotationTarget.FUNCTION,AnnotationTarget.PROPERTY_GETTER,AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value:KClass<out ViewModel>)