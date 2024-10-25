package com.albrivas.fuelpump.feature.fuel_list_station.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.albrivas.fuelpump.core.model.data.FuelType
import com.albrivas.fuelpump.core.model.data.previewFuelStationDomain
import com.albrivas.fuelpump.core.testing.BaseTest
import com.albrivas.fuelpump.feature.favorite_list_station.R
import com.albrivas.fuelpump.feature.favorite_list_station.ui.FavoriteListStationScreen
import com.albrivas.fuelpump.feature.favorite_list_station.ui.FavoriteStationListUiState
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FavoriteListScreenTest : BaseTest() {

    @Test
    @DisplayName("Empty favorites stations")
    fun emptyFavoriteStations() = extension.use {
        setContent {
            FavoriteListStationScreen(
                uiState = FavoriteStationListUiState.EmptyFavorites,
                navigateToDetail = {},
                checkLocationEnabled = {},
            )
        }

        onNodeWithText(getStringResource(R.string.empty_favorites)).assertIsDisplayed()
    }

    @Test
    @DisplayName("Show favorite stations")
    fun favoriteStations() = extension.use {
        setContent {
            FavoriteListStationScreen(
                uiState = FavoriteStationListUiState.Favorites(
                    favoriteStations = listOf(
                        previewFuelStationDomain()
                    ), userSelectedFuelType = FuelType.GASOLINE_95
                ),
                navigateToDetail = {},
                checkLocationEnabled = {},
            )
        }

        onNodeWithTag("item 0").isDisplayed()
    }
}