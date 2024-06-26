package com.albrivas.fuelpump.core.model.data

import android.location.Location
import java.util.Locale

data class FuelStation(
    val bioEthanolPercentage: String,
    val esterMethylPercentage: String,
    val postalCode: String,
    val direction: String,
    val schedule: String,
    val idAutonomousCommunity: String,
    val idServiceStation: Int,
    val idMunicipality: String,
    val idProvince: String,
    val location: Location,
    val locality: String,
    val margin: String,
    val municipality: String,
    val priceGasoilA: Double,
    val priceGasoilB: Double,
    val priceGasoilPremium: Double,
    val priceGasoline95_E10: Double,
    val priceGasoline95_E5: Double,
    val priceGasoline95_E5_Premium: Double,
    val priceGasoline98_E10: Double,
    val priceGasoline98_E5: Double,
    val priceHydrogen: Double,
    val province: String,
    val referral: String,
    val brandStationName: String,
    val brandStationBrandsType: FuelStationBrandsType,
    val typeSale: String,
    val priceCategory: PriceCategory = PriceCategory.NORMAL,
    val distance: Float = 0.0f,
) {
    fun formatDistance(): String {
        return when {
            distance >= 1000 -> {
                val kilometers = distance / 1000
                String.format(Locale.ROOT, "%.2f Km", kilometers)
            }

            distance == distance.toInt().toFloat() -> {
                String.format(Locale.ROOT, "%.0f m", distance)
            }

            else -> {
                String.format(Locale.ROOT, "%.2f m", distance)
            }
        }
    }

    fun formatDirection(): String = direction.lowercase().replaceFirstChar(Char::uppercase)

    val scheduleList get() = schedule.split(";")
}

fun previewFuelStationDomain() = FuelStation(
    bioEthanolPercentage = "",
    esterMethylPercentage = "",
    postalCode = "",
    direction = "C/RIOS ROSAS - MADRID",
    schedule = "L-D: 24H",
    idAutonomousCommunity = "",
    idServiceStation = 1,
    idMunicipality = "",
    idProvince = "",
    location = Location(""),
    locality = "",
    margin = "",
    municipality = "Talavera de la Reina",
    priceGasoilA = 0.0,
    priceGasoilB = 0.0,
    priceGasoilPremium = 0.0,
    priceGasoline95_E10 = 1.659,
    priceGasoline95_E5 = 1.659,
    priceGasoline95_E5_Premium = 1.759,
    priceGasoline98_E10 = 1.759,
    priceGasoline98_E5 = 1.659,
    priceHydrogen = 0.0,
    province = "",
    referral = "",
    brandStationName = "REPSOL",
    brandStationBrandsType = FuelStationBrandsType.REPSOL,
    typeSale = "",
    priceCategory = PriceCategory.CHEAP,
    distance = 0.0f
)

