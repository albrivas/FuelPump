package com.albrivas.fuelpump.feature.fuel_list_station.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.albrivas.fuelpump.core.model.data.FuelStation
import com.albrivas.fuelpump.core.model.data.FuelType
import com.albrivas.fuelpump.core.ui.getPrice
import com.albrivas.fuelpump.core.ui.toBrandStationIcon
import com.albrivas.fuelpump.core.ui.toColor
import com.albrivas.fuelpump.core.uikit.components.alert.AlertTemplate
import com.albrivas.fuelpump.core.uikit.components.alert.AlertTemplateModel
import com.albrivas.fuelpump.core.uikit.components.fuelItem.FuelStationItem
import com.albrivas.fuelpump.core.uikit.components.fuelItem.FuelStationItemModel
import com.albrivas.fuelpump.core.uikit.theme.GrayBackground
import com.albrivas.fuelpump.feature.fuel_list_station.R

@Composable
fun FuelStationListScreenRoute(
    navigateToDetail: (Int) -> Unit,
    viewModel: FuelListStationViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    FuelStationListScreen(
        uiState = state,
        navigateToDetail = navigateToDetail,
        checkLocationEnabled = viewModel::checkLocationEnabled,
    )
}

@Composable
internal fun FuelStationListScreen(
    uiState: FuelStationListUiState,
    navigateToDetail: (Int) -> Unit,
    checkLocationEnabled: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GrayBackground)
            .padding(start = 16.dp, end = 16.dp)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (uiState) {
            FuelStationListUiState.Error -> Unit
            FuelStationListUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = GrayBackground)
                        .statusBarsPadding(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            is FuelStationListUiState.Favorites -> ListFuelStations(
                stations = uiState.favoriteStations,
                selectedFuel = uiState.userSelectedFuelType,
                navigateToDetail = navigateToDetail
            )

            FuelStationListUiState.DisableLocation -> AlertTemplate(
                model = AlertTemplateModel(
                    animation = com.albrivas.fuelpump.core.ui.R.raw.enable_location,
                    description = stringResource(id = R.string.location_disable_description),
                    buttonText = stringResource(id = R.string.button_enable_location),
                    onClick = checkLocationEnabled
                )
            )

            is FuelStationListUiState.EmptyFavorites -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = GrayBackground)
                        .statusBarsPadding(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = R.string.empty_favorites),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnScope.ListFuelStations(
    modifier: Modifier = Modifier,
    stations: List<FuelStation>,
    selectedFuel: FuelType,
    navigateToDetail: (Int) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .weight(1f)
            .background(color = GrayBackground),
        contentPadding = PaddingValues(top = 16.dp, bottom = 24.dp)
    ) {
        itemsIndexed(stations) { index, item ->
            FuelStationItem(
                modifier = Modifier.testTag("item $index").padding(16.dp),
                model = FuelStationItemModel(
                    idServiceStation = item.idServiceStation,
                    icon = item.brandStationBrandsType.toBrandStationIcon(),
                    name = item.brandStationName,
                    distance = item.formatDistance(),
                    price = selectedFuel.getPrice(item),
                    index = index,
                    categoryColor = item.priceCategory.toColor(),
                    onItemClick = navigateToDetail
                )
            )
        }
    }
}

@Preview
@Composable
fun EmptyFavoritesPreview() {
    FuelStationListScreen(
        uiState = FuelStationListUiState.EmptyFavorites,
        navigateToDetail = {},
        checkLocationEnabled = {},
    )
}
