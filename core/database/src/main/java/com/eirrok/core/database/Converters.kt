package com.eirrok.core.database

import androidx.room.TypeConverter
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    fun toOffsetDateTime(value: String?): OffsetDateTime? = value?.let { formatter.parse(value, OffsetDateTime::from) }

    @TypeConverter
    fun fromOffsetDateTime(date: OffsetDateTime?): String? = date?.format(formatter)
}