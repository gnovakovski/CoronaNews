package io.gnovakovski.coronanews.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import io.gnovakovski.coronanews.CustomApplication
import io.gnovakovski.coronanews.injection.module.NetworkModule
import io.gnovakovski.coronanews.injection.module.NewsDaoModule
import io.gnovakovski.coronanews.injection.module.NewsDataModule
import io.gnovakovski.coronanews.injection.module.ViewModelModule
import io.gnovakovski.coronanews.ui.details.DetailActivity
import io.gnovakovski.coronanews.ui.news.NewsListActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, NewsDataModule::class, ViewModelModule::class, NewsDaoModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(customApplication: CustomApplication)
    fun inject(detailActivity: DetailActivity)
    fun inject(newsListActivity: NewsListActivity)
}