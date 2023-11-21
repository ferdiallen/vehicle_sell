package com.ferdialif.vehicleseller.core.cardata

import com.ferdialif.vehicleseller.R
import com.ferdialif.vehicleseller.domain.model.Colors
import com.ferdialif.vehicleseller.domain.model.Motorcycle
import com.ferdialif.vehicleseller.domain.model.SuspensionType
import com.ferdialif.vehicleseller.domain.model.TransmissionType


val bikeData = listOf(
    Motorcycle(
        name = "Suzuki GSX-R 600",
        image = R.raw.gsx_600,
        engine = "599",
        suspension = SuspensionType.SWING_ARM_REAR_SUSPENSION,
        currentStock = 10,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2008,
        sold = 4,
        price = 200_000_000.00,
        color = listOf(Colors.RED.name, Colors.GREEN.name)
    ),
    Motorcycle(
        name = "Suzuki GSX-R 600",
        image = R.raw.gsx_600,
        engine = "599",
        suspension = SuspensionType.SWING_ARM_REAR_SUSPENSION,
        currentStock = 10,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2008,
        sold = 4,
        price = 200_000_000.00,
        color = listOf(Colors.RED.name, Colors.GREEN.name)
    ),
    Motorcycle(
        name = "Suzuki GSX-R 600",
        image = R.raw.gsx_600,
        engine = "599",
        suspension = SuspensionType.SWING_ARM_REAR_SUSPENSION,
        currentStock = 10,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2008,
        sold = 4,
        price = 200_000_000.00,
        color = listOf(Colors.RED.name, Colors.GREEN.name)
    ), Motorcycle(
        name = "Suzuki GSX-R 600",
        image = R.raw.gsx_600,
        engine = "599",
        suspension = SuspensionType.SWING_ARM_REAR_SUSPENSION,
        currentStock = 10,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2008,
        sold = 4,
        price = 200_000_000.00,
        color = listOf(Colors.RED.name, Colors.GREEN.name)
    )
)