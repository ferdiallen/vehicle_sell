package com.ferdialif.vehicleseller.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ferdialif.vehicleseller.domain.model.Bicycle
import com.ferdialif.vehicleseller.domain.model.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {
    @Query("SELECT * FROM Car")
    fun getCarVehicle(): Flow<List<Car>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInitialCarData(data: List<Car>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInitialMotorCycleData(data: List<Bicycle>)
}