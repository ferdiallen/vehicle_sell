package com.ferdialif.vehicleseller.domain.model

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.io.Serial

interface VehicleModel {
    val releaseYear: Int
    val color: List<String>
    val price: Double
}

@Entity
@Serializable
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
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
    override val price: Double = 0.0,
    @StringRes val description: Int? = null
) : VehicleModel

@Entity
@Serializable
data class Motorcycle(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String = "",
    @RawRes val image: Int? = null,
    val engine: String = "",
    val suspension: SuspensionType? = null,
    val currentStock: Int = 0,
    val transmissionType: TransmissionType? = null,
    val sold: Int = 0,
    override val releaseYear: Int = 0,
    override val price: Double = 0.0,
    override val color: List<String> = listOf(),
    @StringRes val description: Int? = null
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

enum class SuspensionType {
    PARALLEL,
    TELESCOPIC,
    TELESCOPIC_UP_DOWN,
    PLUNGED_REAR_SUSPENSION,
    SWING_ARM_REAR_SUSPENSION

}