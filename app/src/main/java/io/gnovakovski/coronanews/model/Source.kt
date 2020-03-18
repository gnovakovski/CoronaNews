package io.gnovakovski.coronanews.model

import androidx.room.Entity

@Entity
data class Source(
    val id: Any,
    val name: String
)