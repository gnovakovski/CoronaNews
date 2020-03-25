package io.gnovakovski.coronanews.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import io.gnovakovski.coronanews.model.database.AppDatabase
import io.gnovakovski.coronanews.ui.details.DetailViewModel
import io.gnovakovski.coronanews.ui.news.NewsListViewModel

class ViewModelFactory(private val activity: AppCompatActivity, title: String, url: String, source: String): ViewModelProvider.Factory{
    val title = title
    val url = url
    val source = source
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "articles").build()
            @Suppress("UNCHECKED_CAST")
            return NewsListViewModel(db.articlesDao()) as T
        }
        else if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(title,url, source) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}