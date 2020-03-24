package io.gnovakovski.coronanews.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.gnovakovski.coronanews.model.Article
import io.gnovakovski.coronanews.model.ArticlesDao
import io.gnovakovski.coronanews.utils.Converters

@Database(entities = arrayOf(Article::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao
}