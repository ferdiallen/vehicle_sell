package com.ferdialif.vehicleseller.core.di

import android.content.Context
import androidx.room.Room
import com.ferdialif.vehicleseller.domain.database.VehicleDatabase
import com.ferdialif.vehicleseller.domain.model.Car
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesVehicleDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            VehicleDatabase::class.java,
            "vehicle_db"
        ).build()
}