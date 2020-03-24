package io.gnovakovski.coronanews.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
   // val source: Source,
    @field:PrimaryKey val title: String,
    val url: String,
    val urlToImage: String
)