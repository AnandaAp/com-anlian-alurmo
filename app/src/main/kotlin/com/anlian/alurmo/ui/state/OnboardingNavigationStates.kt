package com.anlian.alurmo.ui.state

import com.anlian.alurmo.utils.Constants

enum class OnboardingNavigationStates(val route: String) {
    Onboarding(Constants.Onboarding.ONBOARDING),
    SignIn(Constants.Onboarding.SIGN_IN),
    SignUp(Constants.Onboarding.SIGN_UP)
}