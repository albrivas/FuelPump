package com.albrivas.fuelpump.feature.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.profileScreen() {
    composable<ProfileRoute>(
        enterTransition = { null },
        exitTransition = { null },
        popEnterTransition = { null },
        popExitTransition = { null }
    ) {
        ProfileScreenRoute()
    }
}
