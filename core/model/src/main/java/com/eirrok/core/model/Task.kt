package com.eirrok.core.model

import java.time.OffsetDateTime

data class Task(
    val id: Int? = null,
    val title: String,
    val completed: Boolean,
    val repeat: Boolean,
    val remember: Boolean,
    val date: OffsetDateTime,
) {
    companion object {
        fun build() = Task(
            title = "",
            completed = false,
            repeat = false,
            remember = false,
            date = OffsetDateTime.now(),
        )
    }
}