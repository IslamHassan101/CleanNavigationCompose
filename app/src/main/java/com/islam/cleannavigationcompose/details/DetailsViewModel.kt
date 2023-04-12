package com.islam.cleannavigationcompose.details

import androidx.lifecycle.ViewModel
import com.islam.cleannavigationcompose.navigation_utils.AppNavigator
import com.islam.cleannavigationcompose.navigation_utils.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel() {

    fun onBackButtonClicked() {
        appNavigator.tryNavigateBack()
    }

    fun onNavigateToCurrentUserDetailsButtonClicked() {
        appNavigator.tryNavigateTo(
            Destination.UserDetailsScreen(
                firstName = "CurrentUserFirstName",
                lastName = "CurrentUserLastName"
            )
        )
    }
}