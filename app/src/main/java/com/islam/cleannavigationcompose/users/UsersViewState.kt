package com.islam.cleannavigationcompose.users


data class UsersViewState(
    val users: List<User> = listOf(
        User("firstName1", "lastName1"),
        User("firstName2", "lastName2"),
        User("firstName3", "lastName3"),
        User("firstName4", "lastName4")
    )
)

data class User(val firstName: String, val lastName: String)