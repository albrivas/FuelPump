package com.albrivas.feature.station_map.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.albrivas.feature.station_map.navigation.route.StationMapGraph

fun NavGraphBuilder.stationMapGraph(
    navigateToDetail: (Int) -> Unit
) {
    navigation<StationMapGraph.StationMapGraphRoute>(
        startDestination = StationMapGraph.StationMapRoute,
    ) {
        stationMapScreen(navigateToDetail = navigateToDetail)
    }
}