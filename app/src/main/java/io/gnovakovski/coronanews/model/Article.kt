package io.gnovakovski.coronanews.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @field:PrimaryKey(autoGenerate = true) val id: Int,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)