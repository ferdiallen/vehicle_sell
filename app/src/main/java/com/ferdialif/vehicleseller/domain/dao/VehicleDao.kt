package com.ferdialif.vehicleseller.domain.dao

import androidx.room.Dao
import androidx.room.Query
import com.ferdialif.vehicleseller.domain.model.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {
    @Query("SELECT * FROM Car")
    fun getCarVehicle(): Flow<List<Car>>
}