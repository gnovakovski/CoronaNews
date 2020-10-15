package io.gnovakovski.coronanews.injection.module

import android.app.Application
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.gnovakovski.coronanews.data.NewsDefaultRepository
import io.gnovakovski.coronanews.data.NewsRepository
import io.gnovakovski.coronanews.model.ArticlesDao
import io.gnovakovski.coronanews.model.database.AppDatabase
import javax.inject.Singleton

@Module
interface NewsDataModule {
    @[Binds Reusable]
    fun providesRepository(NewsDefaultRepository: NewsDefaultRepository): NewsRepository
}

@Module
object NewsDaoModule {
    @[Provides Reusable JvmStatic]
    fun providesDao(appDatabase: AppDatabase): ArticlesDao {
        return appDatabase.articlesDao()
    }

    @[Provides Singleton JvmStatic]
    fun providesAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "articles"
        ).build()
    }
}
