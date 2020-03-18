package io.gnovakovski.coronanews.utils

import androidx.room.TypeConverter
import io.gnovakovski.coronanews.model.Source

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromSourceToString(data: Source): String = data.name

        @TypeConverter
        @JvmStatic
        fun toInstant(value: String): Source {
            return Source(0, value)
        }
    }
}