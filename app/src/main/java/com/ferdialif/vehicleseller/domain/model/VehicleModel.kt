package com.ferdialif.vehicleseller.domain.model

import androidx.annotation.RawRes
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

interface VehicleModel {
    val releaseYear: Int
    val color: List<String>
    val price: String
}

@Entity
data class Car(
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    val engine: String = "",
    val passengerCapacity: Int = 0,
    val type: CarType? = null,
    val currentStock: Int = 0,
    val transmissionType: TransmissionType? = null,
    val sold: Int = 0,
    @RawRes val image: Int? = null,
    override val releaseYear: Int = 0,
    override val color: List<String> = listOf(),
    override val price: String = "",
) : VehicleModel

data class Bicycle(
    val name: String = "",
    val engine: String = "",
    val suspension: String = "",
    val currentStock: Int = 0,
    val transmissionType: TransmissionType? = null,
    val sold: Int = 0,
    override val releaseYear: Int = 0,
    override val price: String = "",
    override val color: List<String> = listOf()
) : VehicleModel

enum class TransmissionType {
    MANUAL,
    MATIC
}

enum class CarType {
    SEDAN,
    SUV,
    HATCHBACK,
    VAN
}

enum class Colors {
    RED,
    WHITE,
    GREEN,
    YELLOW,
    BLACK
}
