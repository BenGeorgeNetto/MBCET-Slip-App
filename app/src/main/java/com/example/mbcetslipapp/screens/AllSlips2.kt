package com.example.mbcetslipapp.screens
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
import com.example.mbcetslipapp.ui.theme.MBCETSlipAppTheme


@Preview(showBackground = true)
@Composable
fun PTrackerAppCardPreviewstd() {
    MBCETSlipAppTheme() {
        PTrackerAppListstd(ptrackerapplist=AllSlips().loadSlips())
    }
}

@Composable
fun PTrackerAppstd(){
    MBCETSlipAppTheme() {
        PTrackerAppListstd(ptrackerapplist = AllSlips().loadSlips())

    }
}

@Composable
private fun SlipButton(
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
fun TopBarstd(){

    Text(text = "All Slips" , fontSize = 50.sp , fontWeight = FontWeight.Bold , modifier = Modifier.padding(40.dp,20.dp))
}

@Composable
fun SlipDetailsstd(slip: com.example.mbcetslipapp.model.Slip, modifier: Modifier=Modifier){
    Text(
        text = stringResource(id = slip.hname),
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = stringResource(id = slip.tname),
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
    Text(
        text = stringResource(id = slip.description),
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
    Spacer(modifier = Modifier.height(10.dp))
}
@Composable
fun PTrackerAppCardstd(slip: com.example.mbcetslipapp.model.Slip, modifier: Modifier=Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier.padding(30.dp), elevation = 7.dp) {
        Column {
            androidx.compose.foundation.layout.Row(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Column(modifier = Modifier) {
                    Text(
                        text = stringResource(id = slip.sub),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(10.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = slip.status),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(10.dp)
                        )
                        Spacer(modifier = Modifier.width(50.dp))
                        Text(
                            text = stringResource(id = slip.date), fontSize = 20.sp,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
                SlipButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if(expanded){
                SlipDetailsstd(slip = slip)
            }

        }
    }
}

@Composable
fun PTrackerAppListstd(ptrackerapplist :List<com.example.mbcetslipapp.model.Slip>, modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopBarstd() }) {

        LazyColumn(){
            items(ptrackerapplist){ slip->
                PTrackerAppCardstd(slip)
            }
        }
    }
}

