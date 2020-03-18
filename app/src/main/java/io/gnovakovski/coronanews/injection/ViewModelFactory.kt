package io.gnovakovski.coronanews.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import io.gnovakovski.coronanews.model.database.AppDatabase
import io.gnovakovski.coronanews.ui.news.NewsListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "news").build()
            @Suppress("UNCHECKED_CAST")
            return NewsListViewModel(db.articlesDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}