package com.example.mbcetslipapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mbcetslipapp.screens.IdCard
import com.example.mbcetslipapp.ui.theme.MBCETSlipAppTheme

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

    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
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
fun BottomNavBar() {
    // to define bottom navigation bar
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    MBCETSlipAppTheme {
        SlipApp()
    }
}