package com.ferdialif.vehicleseller.core.cardata

import com.ferdialif.vehicleseller.R
import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.model.CarType
import com.ferdialif.vehicleseller.domain.model.Colors
import com.ferdialif.vehicleseller.domain.model.TransmissionType

val tabVehicle = listOf("Car","Bicycle")

val carData = listOf(
    Car(
        name = "Honda Civic Type-R",
        image = R.raw.civic,
        engine = "1996CC",
        passengerCapacity = 5,
        type = CarType.SEDAN,
        releaseYear = 2023,
        currentStock = 20,
        color = listOf(Colors.RED.name, Colors.WHITE.name),
        price = 250_000_000.00,
        transmissionType = TransmissionType.MANUAL,
        sold = 5
    ),
    Car(
        name = "Lamborghini Aventador",
        image = R.raw.aventador,
        engine = "6489CC",
        passengerCapacity = 2,
        type = CarType.SEDAN,
        releaseYear = 2023,
        currentStock = 45,
        color = listOf(Colors.GREEN.name, Colors.WHITE.name),
        price = 400_000_000.00,
        transmissionType = TransmissionType.MANUAL,
        sold = 2
    ),
    Car(
        name = "Pagani Huayra",
        image = R.raw.pagani,
        engine = "5980CC",
        passengerCapacity = 2,
        type = CarType.SEDAN,
        releaseYear = 2018,
        currentStock = 12,
        color = listOf(Colors.BLACK.name, Colors.WHITE.name),
        price = 80_000_000.00,
        transmissionType = TransmissionType.MATIC,
        sold = 4
    ),
    Car(
        name = "Toyota Supra",
        image = R.raw.supra,
        engine = "2998CC",
        passengerCapacity = 2,
        type = CarType.SEDAN,
        releaseYear = 2023,
        currentStock = 100,
        color = listOf(Colors.RED.name, Colors.WHITE.name),
        price = 75_000_000.00,
        transmissionType = TransmissionType.MATIC,
        sold = 5
    ),
    Car(
        name = "Toyota Rush",
        image = R.raw.rush,
        engine = "1496CC",
        passengerCapacity = 7,
        type = CarType.SUV,
        releaseYear = 2023,
        currentStock = 120,
        color = listOf(Colors.RED.name, Colors.WHITE.name),
        price = 50_000_000.00,
        transmissionType = TransmissionType.MATIC,
        sold = 5
    )
)