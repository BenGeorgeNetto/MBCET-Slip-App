package com.example.mbcetslipapp.src

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mbcetslipapp.ui.theme.ListSlipViewModel

@Composable
fun PermissionScreen(listSlipViewModel: ListSlipViewModel = viewModel()) {
    val slipUiState by listSlipViewModel.uiState.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            if(slipUiState.userType=="Student")
                listSlipViewModel.updateUserType("HoD")
            else
                listSlipViewModel.updateUserType("Student")
        },
            modifier = Modifier){
            Text("Switch")
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Button(onClick = {
                listSlipViewModel.updateSelection("Requested")
            },
            modifier = Modifier){
                Text(stringResource(id = R.string.requested))
            }
            Spacer(Modifier.weight(0.5f))
            Button(onClick = {
                listSlipViewModel.updateSelection("Approved")
            },
                modifier = Modifier){
                Text(stringResource(id = R.string.approved))
            }
        }
        Text(text = slipUiState.selection)
        if(slipUiState.selection == "Requested")
            RequestedPermissionScreen()
        else
            ApprovedPermissionScreen()
    }
}

@Composable
fun RequestedPermissionScreen(listSlipViewModel: ListSlipViewModel = viewModel()) {
    val slipUiState by listSlipViewModel.uiState.collectAsState()
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
        items(slips)
        {
                if (!it.status.value)
                    SlipItem(slip = it, userType = slipUiState.userType)
        }
    }
}

@Composable
fun ApprovedPermissionScreen(listSlipViewModel: ListSlipViewModel = viewModel()) {
    val slipUiState by listSlipViewModel.uiState.collectAsState()
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
        items(slips)
        {
            if (it.status.value)
                SlipItem(slip = it, userType = slipUiState.userType)
        }
    }
}

@Composable
fun SlipItem(slip: Slip, modifier: Modifier = Modifier, userType: String) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                SlipData(slip.name, slip.title, stringResource(id = slip.slipType))
                Spacer(Modifier.weight(1f))
                ExpandButton(expanded = expanded, onClick = {expanded = !expanded})
            }
            if (expanded) {
                SlipDescription(slip.slipDescribe)
                Spacer(Modifier.weight(1f))
                if((userType == "Advisor" || userType == "HoD") && !slip.status.value)
                {
                    ApproveButton(
                        onClicked = {
                            slip.acceptStatus()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ApproveButton(
    onClicked: () -> Unit
)
{
    Button(
        onClick = onClicked,
    )
    {
        Text(text = stringResource(id = R.string.approve_slip))
    }
}

@Composable
fun SlipDescription(slipDescribe : String)
{
    Text(
        text = "Description: $slipDescribe",
        modifier = Modifier.padding(8.dp),
        fontSize = 12.sp,
        color = Color.Gray
    )
}

@Composable
fun SlipData (name: String, title: String, type: String)
{
    Column() {
        Text(
            text = "$name: $title",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = type,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp),
            fontSize = 14.sp,
        )
    }
}

@Composable
private fun ExpandButton(
    expanded: Boolean,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            tint = MaterialTheme.colors.secondary,
            contentDescription = "Check Description",
        )
    }
}

@Composable
fun AddRequest(@StringRes slipType: Int, title: String, slipDescribe: String) {
    slips.add(Slip(slipType = slipType, title = title, slipDescribe = slipDescribe))
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlipProjectTrialErrorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            PermissionScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SlipProjectTrialErrorTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            PermissionScreen()
        }
    }
}