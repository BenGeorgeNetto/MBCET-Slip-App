package com.example.mbcetslipapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Note
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Outlined.Home, "Home")
    object Add : NavigationItem("add", Icons.Outlined.Add, "Add")
    object Slips : NavigationItem("slips", Icons.Outlined.Note, "Note")
    object ID : NavigationItem("id", Icons.Outlined.Face, "ID")
}
