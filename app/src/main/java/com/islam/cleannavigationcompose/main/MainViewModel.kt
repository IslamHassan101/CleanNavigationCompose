package com.islam.cleannavigationcompose.main

import androidx.lifecycle.ViewModel
import com.islam.cleannavigationcompose.navigation_utils.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(appNavigator: AppNavigator) : ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
}