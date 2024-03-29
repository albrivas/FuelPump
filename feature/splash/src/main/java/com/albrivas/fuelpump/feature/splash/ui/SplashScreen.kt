package com.albrivas.fuelpump.feature.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.albrivas.fuelpump.core.uikit.R
import com.albrivas.fuelpump.core.uikit.theme.GreenPrimary
import com.albrivas.fuelpump.feature.splash.viewmodel.SplashViewModel

@Composable
fun SplashScreenRoute(
    navigateToOnboarding: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    SplashScreen(
        navigateToOnboarding = navigateToOnboarding,
        navigateToHome = navigateToHome,
        isOnboardingComplete = viewModel.state,
    )
}

@Composable
internal fun SplashScreen(
    navigateToOnboarding: () -> Unit = {},
    navigateToHome: () -> Unit = {},
    isOnboardingComplete: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fuel_pump),
            contentDescription = "",
        )
    }

    LaunchedEffect(isOnboardingComplete) {
        if (isOnboardingComplete)
            navigateToHome()
        else
            navigateToOnboarding()
    }
}

@Composable
@Preview
private fun SplashScreenPreview() {
    SplashScreen(isOnboardingComplete = false)
}