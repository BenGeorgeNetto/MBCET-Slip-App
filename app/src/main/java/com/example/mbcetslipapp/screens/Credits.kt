package com.example.mbcetslipapp.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbcetslipapp.data.AllSlips
import com.example.mbcetslipapp.data.DataSource
import com.example.mbcetslipapp.model.Credit
import com.example.mbcetslipapp.model.Slip
import com.example.mbcetslipapp.ui.theme.MBCETSlipAppTheme

@Preview(showSystemUi = true)




@Composable
fun MBCETApp1(){
    MBCETSlipAppTheme{
        MBCETAppList1(mbcetapplist = DataSource().loadCredits())

    }
}

@Composable
fun MBCETAppList1(mbcetapplist: List<Credit>) {
    Scaffold(topBar = { TopBar1() }) {

        LazyColumn() {
            items(mbcetapplist) { credit ->
                MBCETAppCard1(credit)
            }
        }
    }

}


@Composable
private fun CreditButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = ""
        )
    }
}

@Composable
fun TopBar1(){

    Text(text = "Credits" , fontSize = 50.sp , fontWeight = FontWeight.Bold , modifier = Modifier.padding(40.dp,20.dp))
}

@Composable
fun CreditDetails(credit: Credit,modifier: Modifier=Modifier){
    Column {
        Text(
            text = stringResource(id = credit.username),
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(0.dp))
       
    }
    Spacer(modifier = Modifier.height(10.dp))
}
@Composable
fun MBCETAppCard1(credit:Credit , modifier: Modifier=Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier.padding(10.dp), elevation = 7.dp) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Text(
                    text = stringResource(id = credit.name),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )

                Spacer(modifier = Modifier.width(90.dp))
                CreditButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
                if (expanded) {
                    CreditDetails(credit = credit)
                }


        }


    }

}