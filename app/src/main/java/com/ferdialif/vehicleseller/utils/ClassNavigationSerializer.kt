package com.ferdialif.vehicleseller.utils

import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.model.Motorcycle
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Car.toListSerializer(): String? {
    return try {
        Json.encodeToString(this)
    } catch (e: Exception) {
        null
    }
}

inline fun <reified T>String.toVehicleClass(): T? {
    return try {
        Json.decodeFromString(this)
    } catch (e: Exception) {
        null
    }
}

fun Motorcycle.toListSerializer(): String?{
    return try {
        Json.encodeToString(this)
    } catch (e: Exception) {
        null
    }
}