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
        engine = "599CC",
        suspension = SuspensionType.SWING_ARM_REAR_SUSPENSION,
        currentStock = 10,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2008,
        sold = 4,
        price = 200_000_000.00,
        color = listOf(Colors.RED.name, Colors.GREEN.name),
        description = R.string.gsx600
    ),
    Motorcycle(
        name = "Kawasaki Ninja 250R",
        image = R.raw.kawasaki250,
        engine = "249CC",
        suspension = SuspensionType.TELESCOPIC,
        currentStock = 4,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2009,
        sold = 2,
        price = 50_000_000.00,
        color = listOf(Colors.GREEN.name, Colors.YELLOW.name),
        description = R.string.kawasaki_250r
    ),
    Motorcycle(
        name = "2008 Honda CBR® 1000RR",
        image = R.raw.cbr,
        engine = "999CC",
        suspension = SuspensionType.PLUNGED_REAR_SUSPENSION,
        currentStock = 5,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2008,
        sold = 7,
        price = 90_000_000.00,
        color = listOf(Colors.RED.name, Colors.YELLOW.name),
        description = R.string.cbr
    ), Motorcycle(
        name = "2006 Kawasaki Ninja® ZX-6R",
        image = R.raw.kawasaki_zx,
        engine = "636CC",
        suspension = SuspensionType.SWING_ARM_REAR_SUSPENSION,
        currentStock = 5,
        transmissionType = TransmissionType.MANUAL,
        releaseYear = 2006,
        sold = 4,
        price = 50_000_000.00,
        color = listOf(Colors.BLACK.name, Colors.GREEN.name),
        description = R.string.ninja_zx
    )
)