/*
 * File: FuelStationDao.kt
 * Project: FuelPump
 * Module: FuelPump.core.database.main
 * Last modified: 1/5/23, 12:05 AM
 *
 * Created by albertorivas on 1/5/23, 12:13 AM
 * Copyright © 2023 Alberto Rivas. All rights reserved.
 *
 */

package com.albrivas.fuelpump.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.albrivas.fuelpump.core.database.model.FuelStationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FuelStationDao {
    @Query("SELECT * FROM `fuel-station` WHERE " +
            "(:fuelType = 'GASOLINE_95' AND (priceGasoline95_E5 > 0 OR priceGasoline95_E10 > 0)) OR " +
            "(:fuelType = 'GASOLINE_98' AND (priceGasoline98_E5 > 0 OR priceGasoline98_E10 > 0)) OR " +
            "(:fuelType = 'DIESEL' AND (priceGasoilA > 0 OR priceGasoilB > 0)) OR " +
            "(:fuelType = 'DIESEL_PLUS' AND priceGasoilPremium > 0)")
    fun getFuelStations(fuelType: String): Flow<List<FuelStationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFuelStation(items: List<FuelStationEntity>)
}