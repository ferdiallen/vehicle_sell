package com.ferdialif.vehicleseller.domain.repository

import com.ferdialif.vehicleseller.domain.dao.VehicleDao
import com.ferdialif.vehicleseller.domain.database.VehicleDatabase
import com.ferdialif.vehicleseller.domain.model.Car
import javax.inject.Inject

class VehicleRepository @Inject constructor(
    private val db: VehicleDatabase
) {
    fun readCarValue() = db.dao().getCarVehicle()

    fun readMotorcycleValue() = db.dao().getMotorcycleVehicle()
}