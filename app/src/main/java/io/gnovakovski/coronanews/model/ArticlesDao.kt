package io.gnovakovski.coronanews.model


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ArticlesDao {
    @get:Query("SELECT * FROM article")
    val all: List<Article>

    @Query("SELECT * FROM article where title = :title")
    fun getArticle(title:String): Article

    @Insert
    fun insertAll(vararg articles: Article)
}