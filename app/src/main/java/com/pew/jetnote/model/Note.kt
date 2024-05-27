package com.pew.jetnote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RenameColumn
import androidx.room.util.TableInfo
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "Note_Table")
data class Note(
    @PrimaryKey(autoGenerate = false)
    val uuid: UUID = UUID.randomUUID(),
    @ColumnInfo("Titles")
    var title: String,
    @ColumnInfo("Descriptions")
    val description: String,
    @ColumnInfo("Date")
    val entryDate: Date = Date.from(Instant.now())
)