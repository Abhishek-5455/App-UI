package com.example.assignment.data

data class Tag(
    val text: String,
    val isSelected: Boolean
)

val tags = listOf(
    Tag(
        text = "Coffee",
        isSelected = true
    ),
    Tag(
        text = "Business",
        isSelected = true
    ),
    Tag(
        text = "Hobbies",
        isSelected = false
    ),
    Tag(
        text = "Friendship",
        isSelected = false
    ),
    Tag(
        text = "Movies",
        isSelected = false
    ),
    Tag(
        text = "Dinning",
        isSelected = false
    ),
    Tag(
        text = "Dating",
        isSelected = false
    ),
    Tag(
        text = "Matrimony",
        isSelected = false
    )
)
