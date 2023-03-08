package com.anlian.alurmo.ui.state

import com.anlian.alurmo.utils.Constants

enum class ViewModelStates(val key: String) {
    Activity(Constants.Onboarding.ACTIVITY),
    Onboarding(Constants.Onboarding.ONBOARDING),
    SignIn(Constants.Onboarding.SIGN_IN),
    SignUp(Constants.Onboarding.SIGN_UP)
}