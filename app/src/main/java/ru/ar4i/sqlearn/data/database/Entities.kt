package ru.ar4i.sqlearn.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "completed_sections")
data class CompletedSection(
    @PrimaryKey
    val id: Int
)