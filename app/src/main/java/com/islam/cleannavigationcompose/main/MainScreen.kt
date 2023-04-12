package com.islam.cleannavigationcompose.main

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.islam.cleannavigationcompose.details.DetailsScreen
import com.islam.cleannavigationcompose.home.HomeScreen
import com.islam.cleannavigationcompose.messages.MessagesScreen
import com.islam.cleannavigationcompose.navigation_utils.Destination
import com.islam.cleannavigationcompose.navigation_utils.NavHosts
import com.islam.cleannavigationcompose.navigation_utils.NavigationIntent
import com.islam.cleannavigationcompose.navigation_utils.composable
import com.islam.cleannavigationcompose.ui.theme.CleanNavigationComposeTheme
import com.islam.cleannavigationcompose.user_details.UserDetailsScreen
import com.islam.cleannavigationcompose.users.UsersScreen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {


    val navController = rememberNavController()

    NavigationEffects(
        navigatingChannel = mainViewModel.navigationChannel,
        navHostController = navController
    )

    CleanNavigationComposeTheme {
        Scaffold(
            topBar = {},
            modifier = Modifier.fillMaxSize(),
        ) {
            NavHosts(
                navController = navController,
                startDestination = Destination.HomeScreen,
            ) {

                composable(destination = Destination.HomeScreen) {
                    HomeScreen()
                }
                composable(destination = Destination.UsersScreen) {
                    UsersScreen()
                }
                composable(destination = Destination.UserDetailsScreen) {
                    UserDetailsScreen()
                }
                composable(destination = Destination.MessagesScreen) {
                    MessagesScreen()
                }
                composable(destination = Destination.DetailsScreen) {
                    DetailsScreen()
                }
            }
        }
    }


}


@Composable
fun NavigationEffects(
    navigatingChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)

    LaunchedEffect(activity, navHostController, navigatingChannel) {
        navigatingChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }
                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}
