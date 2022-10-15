package com.example.mbcetslipapp.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mbcetslipapp.R
import com.example.mbcetslipapp.ui.theme.MBCETSlipAppTheme


@Composable
fun ItmsWifiSlip() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            elevation = 8.dp,
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.itms_top_bar),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface,
                    textAlign = TextAlign.Center
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 12.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier,
            ) { StudentDetails() }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 12.dp, end = 12.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier,
            ) { DeviceDetails() }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .padding(16.dp)
                    .size(100.dp, 64.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = "Submit",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun StudentDetails() {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "Student Details",
            style = MaterialTheme.typography.h6
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StudentDetailRow(field = R.string.name_field, value = R.string.name_value)
            StudentDetailRow(field = R.string.id_field, value = R.string.id_value)
            StudentDetailRow(field = R.string.class_field, value = R.string.class_value)
            StudentDetailRow(field = R.string.sem_field, value = R.string.sem_value)
        }
    }
}

@Composable
fun DeviceDetails() {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "Device Details",
            style = MaterialTheme.typography.h6
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DeviceDetailRow(field = R.string.dname_field, value = R.string.dname_value)
            DeviceDetailRow(field = R.string.dbrand_field, value = R.string.dbrand_value)
            DeviceDetailRow(field = R.string.dtype_field, value = R.string.dtype_value)
            DeviceDetailRow(field = R.string.mac_field, value = R.string.mac_value)
        }
    }
}

@Composable
fun StudentDetailRow(field: Int, value: Int) {
    Row() {
        Column(Modifier.weight(.4f)) {
            Text(
                text = stringResource(field),
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Bold
            )
        }
        Column(Modifier.weight(.6f)) {
            Text(
                text = stringResource(value),
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Composable
fun DeviceDetailRow(field: Int, value: Int) {
//    val dName = stringResource(id = R.string.dname_value)
//    var deviceName by remember { mutableStateOf(dName) }
    Row() {
        Column(Modifier
            .weight(.4f)
//            .wrapContentHeight()
        ) {
            Text(
                text = stringResource(field),
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = Modifier
            .weight(.6f),
            verticalArrangement = Arrangement.Center
        ) {
//            DeviceTextField(value = deviceName, onValueChange = { deviceName = it })
            Text(
                text = stringResource(value),
                color = MaterialTheme.colors.onSecondary,
            )
        }
    }
}

//@Composable
//fun DeviceTextField(
//    value: String,
//    onValueChange: (String) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    OutlinedTextField(
//        value = value,
//        onValueChange = onValueChange,
//        singleLine = true,
//        placeholder = {
//            Text(
//                text = value,
//                style = TextStyle(
//                    color = MaterialTheme.colors.onBackground
//                )
//            )
//        },
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = MaterialTheme.colors.onBackground
//        ),
//        modifier = Modifier.height(12.dp)
//    )
//}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    MBCETSlipAppTheme() {
        ItmsWifiSlip()
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    MBCETSlipAppTheme() {
        ItmsWifiSlip()
    }
}