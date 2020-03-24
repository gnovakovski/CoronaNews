package io.gnovakovski.coronanews.base

import androidx.lifecycle.ViewModel
import io.gnovakovski.coronanews.injection.component.DaggerViewModelInjector
import io.gnovakovski.coronanews.injection.component.ViewModelInjector
import io.gnovakovski.coronanews.injection.module.NetworkModule
import io.gnovakovski.coronanews.ui.news.NewsListViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is NewsListViewModel -> injector.inject(this)
        }
    }
}