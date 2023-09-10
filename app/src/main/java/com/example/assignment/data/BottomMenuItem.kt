package com.example.assignment.data

import com.example.assignment.R

data class BottomMenuItem(
    val iconId: Int,
    val text: String
)


val bottomMenuItems = listOf(
    BottomMenuItem(
        iconId = R.drawable.visible,
        text = "Explore"
    ),
    BottomMenuItem(
        iconId = R.drawable.network,
        text = "Network"
    ),
    BottomMenuItem(
        iconId = R.drawable.chat,
        text = "Chat"
    ),
    BottomMenuItem(
        iconId = R.drawable.contacts,
        text = "Contacts"
    ),
    BottomMenuItem(
        iconId = R.drawable.groups,
        text = "Groups"
    ),
)