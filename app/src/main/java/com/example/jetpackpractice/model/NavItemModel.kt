package com.example.jetpackpractice.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItemModel(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeNum: Int
)