package com.anlian.alurmo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.anlian.alurmo.ui.state.OnboardingNavigationStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "OnboardingViewModel"

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {
    init {
        viewModelScope.launch(IO) {
            Log.e(TAG, "Initiate Onboarding")
        }
    }

    fun navigateToSignIn(navController: NavHostController) {
        navController.navigate(OnboardingNavigationStates.SignIn.route) {
            popUpTo(OnboardingNavigationStates.Onboarding.route)
        }
    }
}