package com.example.mbcetslipapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mbcetslipapp.data.AllSlips
import com.example.mbcetslipapp.screens.*
import com.example.mbcetslipapp.ui.theme.*
import java.security.AccessController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBCETSlipAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SlipApp()
                }
            }
        }
    }
}


@Composable
fun SlipApp() {
    SlipHome()
}


@Composable
fun SlipHome() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier,
        content = { padding ->
            Box() {
                Navigation(navController = navController)
            }
        }
    )

}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreenStudent()
        }
        composable(NavigationItem.Add.route) {
            CreateSlipLayout()
        }
        composable(NavigationItem.Slips.route) {
            PermissionScreen()
        }
        composable(NavigationItem.Wifi.route) {
            ItmsWifiSlip()
        }
        composable(NavigationItem.ID.route) {
            IdCard()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LightPreview() {
    MBCETSlipAppTheme {
        SlipApp()
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Add,
        NavigationItem.Slips,
        NavigationItem.Wifi,
        NavigationItem.ID
    )
    BottomNavigation(
        backgroundColor = Grey8,
        contentColor = Grey1,
        elevation = 4.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { item.icon },
                label = { Text(item.title) },
                selectedContentColor = PrimBlue,
                unselectedContentColor = PrimCream,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    MBCETSlipAppTheme {
        SlipApp()
    }
}