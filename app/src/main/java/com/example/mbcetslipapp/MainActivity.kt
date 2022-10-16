package com.example.mbcetslipapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mbcetslipapp.data.AllSlips
import com.example.mbcetslipapp.screens.*
import com.example.mbcetslipapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBCETSlipAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PTrackerAppListstd(ptrackerapplist= AllSlips().loadSlips())
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
    Scaffold(
        bottomBar = { BottomNavigationBar() },
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
    ) {
        IdCard()
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
fun TopAppBar() {
    // to define top app bar
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Add,
        NavigationItem.Slips,
        NavigationItem.ID
    )
    BottomNavigation(
        backgroundColor = Grey8,
        contentColor = Grey1,
        elevation = 4.dp
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { item.icon },
                label = { Text(item.title) },
                selectedContentColor = PrimGreen,
                unselectedContentColor = PrimCream,
                alwaysShowLabel = true,
                selected = false,
                onClick = {

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