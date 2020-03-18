package io.gnovakovski.coronanews.injection.component

import dagger.Component
import io.gnovakovski.coronanews.injection.module.NetworkModule
import io.gnovakovski.coronanews.ui.news.NewsListViewModel
import io.gnovakovski.coronanews.ui.news.NewsViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified NewsListViewModel.
     * @param newsListViewModel NewsListViewModel in which to inject the dependencies
     */
    fun inject(newsListViewModel: NewsListViewModel)
    /**
     * Injects required dependencies into the specified NewsViewModel.
     * @param newsViewModel NewsViewModel in which to inject the dependencies
     */
    fun inject(newsViewModel: NewsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}