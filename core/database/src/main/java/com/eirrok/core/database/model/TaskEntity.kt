package com.eirrok.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "repeat") val repeat: Boolean,
    @ColumnInfo(name = "remember") val remember: Boolean,
    @ColumnInfo(name = "completed") val completed: Boolean,
    @ColumnInfo(name = "date") val date: OffsetDateTime,
)