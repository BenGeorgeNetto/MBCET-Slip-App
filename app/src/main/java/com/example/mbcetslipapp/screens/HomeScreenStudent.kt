package com.example.mbcetslipapp.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mbcetslipapp.R
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
        ) {
            Text(
                text = "Hi $name"
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