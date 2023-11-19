package com.ferdialif.vehicleseller.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
class TypeConverter {
    @TypeConverter
    fun saveListOfColorsIntoDatabase(data: List<String>): String {
        return Json.encodeToString(data)
    }

    @TypeConverter
    fun readStringColorFromDatabase(data: String): List<String> {
        return Json.decodeFromString(data)
    }
}