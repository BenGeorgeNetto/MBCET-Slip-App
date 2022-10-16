package com.example.mbcetslipapp.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mbcetslipapp.R
import com.example.mbcetslipapp.SlipViewModel
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun SlipCreateTopBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        title = {
            Text(
                text = stringResource(R.string.CreateASlip),
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
        backgroundColor = MaterialTheme.colors.background,
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
                    text = stringResource(R.string.FillUpSlipDetails),
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    thickness = 2.dp,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(R.string.Name),
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Text(
                    text = stringResource(id =R.string.id_name),
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = stringResource(R.string.RegNo),
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(
                            text = stringResource(id =R.string.id),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Box(
                        Modifier.weight(2f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.AdmnNo),
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Text(
                                text = stringResource(id = R.string.adnod1),
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
                            text = stringResource(R.string.ClassTitle),
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(
                            text = stringResource(R.string.CS1),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box(
                        Modifier.weight(2f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.SemesterTitle),
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Text(
                                text = stringResource(R.string.semester),
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                val bg =MaterialTheme.colors.background
                val bg2=MaterialTheme.colors.onSurface
                Canvas(
                    Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                ) {
                    drawCircle(bg, 50f, center = Offset(-50f, 0f))
                    drawCircle(bg, 50f, center = Offset(size.width + 50f, 0f))
                    drawLine(
                        color = bg2,
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
                    text = stringResource(R.string.CreateSlipFooter),
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
                Text(stringResource(R.string.GatePass))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "ID Card Duplicate"
            }) {
                Text(stringResource(R.string.IDCardDuplicate))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "Lab access request"
            }) {
                Text(stringResource(R.string.LabAccessRequest))
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
                Text(stringResource(R.string.ExamGrievances))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                selected = "Misc"
            }) {
                Text(stringResource(R.string.Misc))
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
        text = stringResource(R.string.SendTo),
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
            Text(text = stringResource(R.string.HOD), fontWeight = FontWeight.Bold,)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            val sendToAdvisors = remember { mutableStateOf(false) }

            Checkbox(
                checked = viewModel.sendToAdvisors,
                onCheckedChange = { viewModel.sendToAdvisors = it },
                enabled = true,
                colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
            )
            Text(text = stringResource(R.string.Advisors), fontWeight = FontWeight.Bold,)
        }
    }

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .height(40.dp)
    ) {
        Text(text = stringResource(R.string.SubmitButtomText),
        fontSize = 20.sp)
    }
}
