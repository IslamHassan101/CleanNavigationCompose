package com.islam.cleannavigationcompose.messages

import androidx.lifecycle.ViewModel
import com.islam.cleannavigationcompose.navigation_utils.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel() {

    fun onBackButtonClicked() {
        appNavigator.tryNavigateBack()
    }
}