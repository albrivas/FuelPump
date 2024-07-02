package com.albrivas.fuelpump.feature.splash.state

sealed interface SplashUiState {
    data object Loading : SplashUiState
    data object Error : SplashUiState
    data object Success : SplashUiState
}
