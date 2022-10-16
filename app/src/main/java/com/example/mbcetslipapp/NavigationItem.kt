package com.example.mbcetslipapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Outlined.Home, "Home")
    object Add : NavigationItem("add", Icons.Outlined.Add, "Create Request")
    object Slips : NavigationItem("slips", Icons.Outlined.Note, "All Slips")
    object Wifi: NavigationItem("wifi", Icons.Outlined.Wifi, "Wifi Request")
    object ID : NavigationItem("id", Icons.Outlined.Face, "Virtual ID")
}
