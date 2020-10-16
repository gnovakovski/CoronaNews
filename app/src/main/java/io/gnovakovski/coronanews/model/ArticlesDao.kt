package io.gnovakovski.coronanews.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticlesDao {
    @Query("SELECT * FROM article")
    suspend fun getAllArticles(): List<Article>

    @Query("SELECT * FROM article where title = :title")
    suspend fun getArticle(title: String): Article

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>): List<Long>
}