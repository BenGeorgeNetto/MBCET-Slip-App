package com.example.mbcetslipapp.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mbcetp_tracker.ui.theme.MBCETPTrackerTheme
import java.text.SimpleDateFormat
import java.util.Date


@Composable
fun SlipCreateTopBar() {
    TopAppBar(
        backgroundColor = Color.Black,
        contentColor = Color.White,
        title = {
            Text(
                text = "Create a Slip",
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "back",
                )
            }
        },
        elevation = 12.dp
    )
}


@Composable
fun CreateSlipLayout(model: SlipViewModel = viewModel()) {
    val scroll = rememberScrollState(0)
    Scaffold(
        topBar = { SlipCreateTopBar() },
        backgroundColor = Color.Black,
        ) {
        Card(
            elevation = 12.dp,
            modifier = Modifier
                .verticalScroll(scroll, reverseScrolling = true)
                .padding(all = 20.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    TypeSelectorDropdown()
                    val sdf = SimpleDateFormat("dd/MM/yyyy")
                    val currentDateAndTime = sdf.format(Date())
                    Box(
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = currentDateAndTime,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Fill up slip details",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    thickness = 2.dp,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Name",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Text(
                    text = "Arnorld Sivasankaran",
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = "RegNo",
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(
                            text = "MBT69420",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Box(
                        Modifier.weight(2f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = "AdmnNo",
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Text(
                                text = "69420",
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = "Class",
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(
                            text = "CS2",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Box(
                        Modifier.weight(2f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = "Semester",
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Text(
                                text = "S3",
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                Canvas(
                    Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                ) {
                    drawCircle(Color.Black, 50f, center = Offset(-50f, 0f))
                    drawCircle(Color.Black, 50f, center = Offset(size.width + 50f, 0f))
                    drawLine(
                        color = Color.DarkGray,
                        strokeWidth = 20f,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        pathEffect = pathEffect
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                InputFields(model)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "*This slip will submitted for approval to your department faculties",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    onChange: (String) -> Unit = {},
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyBoardActions: KeyboardActions = KeyboardActions(),
    isEnabled: Boolean = true
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = onChange,
        leadingIcon = leadingIcon,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.primary),
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyBoardActions,
        enabled = isEnabled,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            disabledBorderColor = Color.Gray,
            disabledTextColor = Color.Black
        ),
        placeholder = {
            Text(text = placeholder, style = TextStyle(fontSize = 18.sp))
        }
    )
}



@Composable
fun TypeSelectorDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selected: String? by remember { mutableStateOf(null) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(
                text = selected ?: "Select Type",
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "Gate Pass"
            }) {
                Text("Gate Pass")
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "ID Card Duplicate"
            }) {
                Text("ID Card Duplicate")
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "Lab access request"
            }) {
                Text("Lab access request")
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "Extra class request"
            }) {
                Text("Extra class request")
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "Exam Grievances"
            }) {
                Text("Exam Grievances")
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "Misc"
            }) {
                Text("Misc")
            }
        }
    }
}

@Composable
fun InputFields(
    viewModel: SlipViewModel
) {
    val focusManager = LocalFocusManager.current
    AppTextField(
        text = viewModel.title,
        placeholder = "Title",
        onChange = {
            viewModel.title = it
        },
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Text,
        keyBoardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
    Spacer(modifier = Modifier.height(5.dp))
    AppTextField(
        modifier = Modifier.height(100.dp),
        text = viewModel.description,
        placeholder = "Description",
        onChange = {
            viewModel.description = it
        },
        imeAction = ImeAction.Default,
        keyboardType = KeyboardType.Text,
        keyBoardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )

    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = "Send To",
        fontWeight = FontWeight.Bold,
        color = Color.Gray
    )
    Row() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = viewModel.sendToHOD,
                onCheckedChange = { viewModel.sendToHOD = it },
                enabled = true,
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(text = "HOD", fontWeight = FontWeight.Bold,)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            val sendToAdvisors = remember { mutableStateOf(false) }

            Checkbox(
                checked = viewModel.sendToAdvisors,
                onCheckedChange = { viewModel.sendToAdvisors = it },
                enabled = true,
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(text = "Advisors", fontWeight = FontWeight.Bold,)
        }
    }

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .height(40.dp)
    ) {
        Text(text = "Submit",
        fontSize = 20.sp)
    }
}
