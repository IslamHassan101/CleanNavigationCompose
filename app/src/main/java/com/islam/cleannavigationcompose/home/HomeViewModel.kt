package com.islam.cleannavigationcompose.home

import androidx.lifecycle.ViewModel
import com.islam.cleannavigationcompose.navigation_utils.AppNavigator
import com.islam.cleannavigationcompose.navigation_utils.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val appNavigator: AppNavigator) : ViewModel() {

    fun onNavigateToUsersButtonClicked() {
        appNavigator.tryNavigateTo(Destination.UsersScreen())
    }

    fun onNavigateToMessageButtonClick() {
        appNavigator.tryNavigateTo(Destination.MessagesScreen())
    }

    fun onNavigateToDetailsButtonClick() {
        appNavigator.tryNavigateTo(Destination.DetailsScreen())
    }
}