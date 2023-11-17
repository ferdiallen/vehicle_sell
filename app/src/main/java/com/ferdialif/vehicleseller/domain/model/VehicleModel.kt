package com.ferdialif.vehicleseller.domain.model

import androidx.compose.ui.graphics.Color

interface VehicleModel {
    val releaseYear: Int
    val color: Color
    val price: String
}

data class Car(
    val engine: String = "",
    val passengerCapacity: Int = 0,
    val type: CarType? = null,
    override val releaseYear: Int = 0,
    override val color: Color = Color.Unspecified,
    override val price: String = "",
) : VehicleModel

data class Bicycle(
    val engine: String = "",
    val suspension: String = "",
    val transmissionType: TransmissionType? = null,
    override val releaseYear: Int = 0,
    override val price: String = "",
    override val color: Color = Color.Unspecified
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
