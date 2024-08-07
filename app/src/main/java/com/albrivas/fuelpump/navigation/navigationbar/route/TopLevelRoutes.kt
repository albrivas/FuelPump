package com.albrivas.fuelpump.navigation.navigationbar.route

import com.albrivas.feature.station_map.navigation.route.StationMapGraph
import com.albrivas.fuelpump.core.uikit.R
import com.albrivas.fuelpump.feature.fuel_list_station.navigation.route.StationListGraph
import kotlinx.serialization.Serializable

@Serializable
sealed class TopLevelRoutes {
    @Serializable
    data class Map(
        val icon: Int = R.drawable.ic_map,
        val route: String = "map_route"
    ) : TopLevelRoutes()

    @Serializable
    data class List(
        val icon: Int = R.drawable.ic_list,
        val route: String = "list_route"
    ) : TopLevelRoutes()

    @Serializable
    data class Profile(
        val icon: Int = R.drawable.ic_profile,
        val route: String = "profile_route"
    ) : TopLevelRoutes()

    companion object {
        fun fromRoute(route: String?): String? {
            return when {
                route?.contains("${StationMapGraph.StationMapRoute::class.simpleName}") == true -> Map().route
                route?.contains("${StationListGraph.StationListRoute::class.simpleName}") == true -> List().route
                route?.contains("ProfileRoute") == true -> Profile().route
                else -> null
            }
        }
    }
}
