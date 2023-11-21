package com.ferdialif.vehicleseller.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ferdialif.vehicleseller.domain.dao.VehicleDao
import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.model.Motorcycle
import com.ferdialif.vehicleseller.utils.TypeConverter


@TypeConverters(TypeConverter::class)
@Database(entities = [Car::class,Motorcycle::class], version = 1)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun dao(): VehicleDao
}