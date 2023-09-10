package com.example.assignment.data

data class User(
    val name: String,
    val location: String,
    val profession: String,
    val tags: List<String>,
    val distance: String,
    val about: String
)

val users = listOf(
    User(
        name = "Abhishek Rathod",
        location = "Nagpur",
        profession = "Student",
        tags = listOf("Coffee" , "Friendship"),
        distance = "100 m",
        about = "Hi community! I am open to new\nconnections"
    ),
    User(
        name = "John Jacob",
        location = "Mumbai",
        profession = "Student",
        tags = listOf("Coffee" , "Friendship" , "Business"),
        distance = "400 Km",
        about = "Hi community! I am open to new\nconnections"
    ),
    User(
        name = "Mansi Yeole",
        location = "Nagpur",
        profession = "Student",
        tags = listOf("Coffee" , "Friendship" , "Business"),
        distance = "800-900 m",
        about = "Hi community! I am open to new\nconnections"
    ),
    User(
        name = "Harsh Raut",
        location = "Wardha",
        profession = "Student",
        tags = listOf("Coffee" , "Friendship", "Dating"),
        distance = "100 Km",
        about = "Hi community! I am open to new\nconnections"
    ),
    User(
        name = "Nilesh Kapse",
        location = "Pune",
        profession = "Student",
        tags = listOf("Coffee" , "Friendship"),
        distance = "300 km",
        about = "Hi community! I am open to new\nconnections"
    ),

)