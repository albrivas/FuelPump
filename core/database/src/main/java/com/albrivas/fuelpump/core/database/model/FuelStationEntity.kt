/*
 * File: FuelStationEntity.kt
 * Project: FuelPump
 * Module: FuelPump.core.database.main
 * Last modified: 1/4/23, 10:13 PM
 *
 * Created by albertorivas on 1/5/23, 12:13 AM
 * Copyright © 2023 Alberto Rivas. All rights reserved.
 *
 */

package com.albrivas.fuelpump.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "fuel-station"
)
data class FuelStationEntity(
    val bioEthanolPercentage: String,
    val esterMethylPercentage: String,
    val postalCode: String,
    val direction: String,
    val schedule: String,
    val idAutonomousCommunity: String,
    @PrimaryKey(autoGenerate = true)
    val idServiceStation: Int,
    val idMunicipality: String,
    val idProvince: String,
    val latitude: String,
    val locality: String,
    val longitudeWGS84: String,
    val margin: String,
    val municipality: String,
    val priceBiodiesel: String,
    val priceBioEthanol: String,
    val priceGasNaturalCompressed: String,
    val priceLiquefiedNaturalGas: String,
    val priceLiquefiedPetroleumGas: String,
    val priceGasoilA: String,
    val priceGasoilB: String,
    val priceGasoilPremium: String,
    val priceGasoline95_E10: String,
    val priceGasoline95_E5: String,
    val priceGasoline95_E5_Premium: String,
    val priceGasoline98_E10: String,
    val priceGasoline98_E5: String,
    val priceHydrogen: String,
    val province: String,
    val referral: String,
    val brandStation: String,
    val typeSale: String
)
