package com.ferdialif.vehicleseller.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.model.Motorcycle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {
    @Query("SELECT * FROM Car")
    fun getCarVehicle(): Flow<List<Car>>

    @Query("SELECT * FROM MOTORCYCLE")
    fun getMotorcycleVehicle():Flow<List<Motorcycle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInitialCarData(data: Car)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInitialMotorCycleData(data: Motorcycle)
}