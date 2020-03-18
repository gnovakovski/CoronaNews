package io.gnovakovski.coronanews.model


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ArticlesDao {
    @get:Query("SELECT * FROM article")
    val all: List<Article>

    @Insert
    fun insertAll(vararg articles: Article)
}