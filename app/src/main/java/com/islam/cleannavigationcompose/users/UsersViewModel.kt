package com.islam.cleannavigationcompose.users

import androidx.lifecycle.ViewModel
import com.islam.cleannavigationcompose.navigation_utils.AppNavigator
import com.islam.cleannavigationcompose.navigation_utils.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(private val appNavigator: AppNavigator) : ViewModel() {
    private val _viewState = MutableStateFlow(UsersViewState())

    val viewState = _viewState.asStateFlow()

    fun onBackButtonClicked() {
        appNavigator.tryNavigateBack()
    }

    fun onUserRowClicked(user: User) {
        appNavigator.tryNavigateTo(
            Destination.UserDetailsScreen(
                firstName = user.firstName,
                lastName = user.lastName
            )
        )
    }
}