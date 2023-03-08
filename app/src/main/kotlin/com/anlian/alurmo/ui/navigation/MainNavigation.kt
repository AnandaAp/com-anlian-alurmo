package com.anlian.alurmo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anlian.alurmo.ui.state.OnboardingNavigationStates

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = OnboardingNavigationStates.Onboarding.name
    ) {
        composable(route = OnboardingNavigationStates.Onboarding.name) {
            OnboardingNavigation(mainNavController = navController)
        }
    }
}