package com.albrivas.fuelpump.feature.station_map.ui

import com.albrivas.fuelpump.core.model.data.RecentSearchQuery

sealed interface RecentSearchQueriesUiState {
    data object Loading : RecentSearchQueriesUiState

    data class Success(
        val recentQueries: List<RecentSearchQuery> = emptyList(),
    ) : RecentSearchQueriesUiState
}
