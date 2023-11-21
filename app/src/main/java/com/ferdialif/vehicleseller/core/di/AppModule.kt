package com.ferdialif.vehicleseller.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ferdialif.vehicleseller.core.cardata.bikeData
import com.ferdialif.vehicleseller.core.cardata.carData
import com.ferdialif.vehicleseller.domain.database.VehicleDatabase
import com.ferdialif.vehicleseller.domain.model.Car
import com.ferdialif.vehicleseller.domain.repository.VehicleRepository
import com.ferdialif.vehicleseller.utils.TypeConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private lateinit var database: VehicleDatabase

    @Provides
    @Singleton
    fun providesVehicleDatabase(@ApplicationContext context: Context, scope: CoroutineScope):
            VehicleDatabase {
        database = Room.databaseBuilder(
            context,
            VehicleDatabase::class.java,
            "vehicle_db"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                scope.launch {
                    carData.forEach {
                        database.dao().insertInitialCarData(it)
                    }
                    bikeData.forEach {
                        database.dao().insertInitialMotorCycleData(it)
                    }
                }
            }
        })
            .build()
        return database
    }

    @Provides
    @Singleton
    fun providesCoroutineScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }

    @Provides
    @Singleton
    fun providesVehicleRepository(db: VehicleDatabase): VehicleRepository {
        return VehicleRepository(db)
    }
}
