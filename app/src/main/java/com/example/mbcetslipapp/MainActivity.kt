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
import com.example.mbcetslipapp.screens.HomeScreenStudent
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
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colors.background),
//        topBar = { SlipHomeTopBar() }
    ) {
        SlipHome()
    }
}


@Composable
fun SlipHome() {
    HomeScreenStudent()
}

@Preview(showSystemUi = true)
@Composable
fun LightPreview() {
    MBCETSlipAppTheme {
        SlipApp()
    }
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

//@Composable
//fun SlipHomeTopBar() {
//    TopAppBar(
//        backgroundColor = MaterialTheme.colors.background,
//        contentColor = MaterialTheme.colors.onBackground,
//        title = {
//            Text(
//                text = stringResource(id = R.string.app_name)
//            )
//        },
////        navigationIcon = {
////            IconButton(onClick = { }) {
////                Icon(
////                    Icons.Filled.ArrowBack,
////                    contentDescription = "back",
////                )
////            }
////        },
//        elevation = 12.dp
//    )
//}
