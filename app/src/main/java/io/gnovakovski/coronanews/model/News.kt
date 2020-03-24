package io.gnovakovski.coronanews.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class News(
    @field:PrimaryKey(autoGenerate = true) val id : Int,
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)