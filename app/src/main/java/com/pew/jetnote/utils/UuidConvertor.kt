package com.pew.jetnote.utils

import androidx.room.TypeConverter
import java.util.UUID

class UuidConvertor {
    @TypeConverter
    fun uuidToString(uuid: UUID): String? {
        return uuid.toString()
    }
    @TypeConverter
    fun StringToUuid(string: String?): UUID {
        return UUID.fromString(string)
    }
}