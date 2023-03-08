package com.anlian.alurmo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anlian.alurmo.ui.state.OnboardingNavigationStates
import com.anlian.alurmo.ui.view.onboarding.authentication.Onboarding
import com.anlian.alurmo.ui.view.onboarding.authentication.SignIn
import com.anlian.alurmo.viewmodel.OnboardingViewModel

@Composable
fun OnboardingNavigation(
    mainNavController: NavHostController
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OnboardingNavigationStates.Onboarding.route
    ) {
        composable(route = OnboardingNavigationStates.Onboarding.route) {
            val viewModel = hiltViewModel<OnboardingViewModel>()
            Onboarding(viewModel = viewModel, navController = mainNavController)
        }

        composable(route = OnboardingNavigationStates.SignIn.route) {
            SignIn()
        }

        composable(route = OnboardingNavigationStates.SignUp.route) {

        }
    }
}