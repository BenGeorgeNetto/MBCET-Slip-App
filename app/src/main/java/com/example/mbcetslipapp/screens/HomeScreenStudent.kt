package com.example.mbcetslipapp.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbcetslipapp.R
import com.example.mbcetslipapp.ui.theme.Grey5
import com.example.mbcetslipapp.ui.theme.MBCETSlipAppTheme

@Composable
fun HomeScreenStudent() {
    val name = stringResource(id = R.string.name_value)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "Hi $name",
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onBackground
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .size(150.dp, 150.dp)
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            text = "No of pending Requests",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Row() {
                        Text(
                            text = "2",
                            fontSize = 48.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Card(
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .size(150.dp, 150.dp)
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            text = "No of accepted Requests",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Row() {
                        Text(
                            text = "1",
                            fontSize = 48.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(36.dp))

        HomeScreenNotification(notif = "${stringResource(id = R.string.hod_cs)} " +
                "has accepted your request for access to lab during honors hours. " +
                "Check your mail for more details")
        HomeScreenNotification(notif = "${stringResource(id = R.string.advisor_1)} " +
                "has forwarded your request regarding permission to leave early to the HOD")
        HomeScreenNotification(notif = "${stringResource(id = R.string.advisor_2)} " +
                "has forwarded your request regarding hosting the freshers day to the HOD")
    }
}

@Composable
fun HomeScreenNotification(notif: String) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp),
        backgroundColor = Grey5
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = notif,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeLightPreview() {
    MBCETSlipAppTheme {
        HomeScreenStudent()
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeDarkPreview() {
    MBCETSlipAppTheme {
        HomeScreenStudent()
    }
}