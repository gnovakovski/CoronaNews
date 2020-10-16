package io.gnovakovski.coronanews.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import io.gnovakovski.coronanews.injection.ViewModelProviderFactory
import io.gnovakovski.coronanews.ui.news.NewsListViewModel
import kotlin.reflect.KClass

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(viewModel: ViewModelProviderFactory): ViewModelProvider.Factory

    @[Binds IntoMap ViewModelKey(NewsListViewModel::class)]
    fun bindsNewsListViewModel(newsListViewModel: NewsListViewModel): ViewModel
}
