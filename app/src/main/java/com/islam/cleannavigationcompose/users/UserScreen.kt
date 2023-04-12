package com.islam.cleannavigationcompose.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun UsersScreen(userViewModel: UsersViewModel = hiltViewModel()) {

    val viewState = userViewModel.viewState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { userViewModel.onBackButtonClicked() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
            Text(text = "UsersScreen")
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(viewState.users) {
                    UserRow(user = it) { user ->
                        userViewModel.onUserRowClicked(user)
                    }
                }
            }
        }
    }
}

@Composable
fun UserRow(
    user: User, onUserClick: (User) -> Unit
) {
    Spacer(modifier = Modifier.height(16.dp))
    Card(modifier = Modifier.fillMaxWidth(), elevation = 8.dp) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { onUserClick(user) }
            .padding(16.dp)) {
            Text(text = "${user.firstName} ${user.lastName}")
        }
    }
}