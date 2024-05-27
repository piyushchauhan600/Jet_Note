package com.pew.jetnote.utils

import android.renderscript.Sampler.Value
import androidx.compose.runtime.rememberUpdatedState
import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.Date

class DateConvertor {
    @TypeConverter
    fun dateToLong(date: Date): Long {
        return date.time
    }
    @TypeConverter
    fun longToDate(timestamp: Long): Date {
        return Date(timestamp)
    }
}