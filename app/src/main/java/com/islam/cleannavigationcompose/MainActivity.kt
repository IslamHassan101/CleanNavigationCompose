package com.islam.cleannavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.islam.cleannavigationcompose.main.MainScreen
import com.islam.cleannavigationcompose.ui.theme.CleanNavigationComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanNavigationComposeTheme {
                MainScreen()
            }
        }
    }
}

