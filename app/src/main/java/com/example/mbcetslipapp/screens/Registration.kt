package com.example.mbcetslipapp.screens

import android.os.Bundle
import android.view.WindowManager
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mbcetslipapp.SlipHome

@Composable
fun LoginAndRegistration() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "register_screen", builder = {
        composable(
            "register_screen",
            content = { RegistrationScreen(navController = navController) }
        )
        composable(
            "home",
            content = { SlipHome() }
        )

        composable(
            "login",
            content = { Login() }
        )
    })
}


@Composable
fun RegistrationScreen(navController: NavController) {
    val context = LocalContext.current
    val name = remember {
        mutableStateOf(TextFieldValue())
    }
    val email = remember { mutableStateOf(TextFieldValue()) }
    val mbcetID = remember { mutableStateOf(TextFieldValue()) }
    val mobileNo = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val confirmPassword = remember { mutableStateOf(TextFieldValue()) }

    val nameErrorState = remember { mutableStateOf(false) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val confirmPasswordErrorState = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    Card(contentColor = MaterialTheme.colors.onBackground,) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(MaterialTheme.colors.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {

            Text(text = buildAnnotatedString {

                withStyle(style = SpanStyle(color = MaterialTheme.colors.onBackground)) {
                    append("Registration")
                }
            }, fontSize = 30.sp)
            Spacer(Modifier.size(16.dp))
            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    if (nameErrorState.value) {
                        nameErrorState.value = false
                    }
                    name.value = it
                },

                modifier = Modifier.fillMaxWidth(),
                isError = nameErrorState.value,
                label = {
                    Text(text = "Name*")
                },
            )
            if (nameErrorState.value) {
                Text(text = "Required", color = MaterialTheme.colors.primary)
            }
            Spacer(Modifier.size(16.dp))

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    if (emailErrorState.value) {
                        emailErrorState.value = false
                    }
                    email.value = it
                },

                modifier = Modifier.fillMaxWidth(),
                isError = emailErrorState.value,
                label = {
                    Text(text = "MBCET Email*")
                },
            )
            if (emailErrorState.value) {
                Text(text = "Required", color = MaterialTheme.colors.primary)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row() {
                OutlinedTextField(
                    value = mbcetID.value,
                    onValueChange = {

                        mbcetID.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        autoCorrect = false
                    ),
                    modifier = Modifier.fillMaxWidth(0.3f),
                    label = {
                        Text(text = "MBCET ID")
                    },
                )
                Spacer(modifier = Modifier.size(16.dp))
                OutlinedTextField(
                    value = mobileNo.value,
                    onValueChange = {

                        mobileNo.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        autoCorrect = false
                    ),
                    label = {
                        Text(text = "Mobile No")
                    },
                )
            }

            Spacer(Modifier.size(16.dp))
            val passwordVisibility = remember { mutableStateOf(true) }
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    if (passwordErrorState.value) {
                        passwordErrorState.value = false
                    }
                    password.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password*")
                },
                isError = passwordErrorState.value,
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            imageVector = if (passwordVisibility.value) Icons.Default.Check else Icons.Default.CheckCircle,
                            contentDescription = "visibility",
                            tint = MaterialTheme.colors.primary
                        )
                    }
                },
                visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
            )
            if (passwordErrorState.value) {
                Text(text = "Required", color = MaterialTheme.colors.primary)
            }

            Spacer(Modifier.size(16.dp))
            val cPasswordVisibility = remember { mutableStateOf(true) }
            OutlinedTextField(
                value = confirmPassword.value,
                onValueChange = {
                    if (confirmPasswordErrorState.value) {
                        confirmPasswordErrorState.value = false
                    }
                    confirmPassword.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                isError = confirmPasswordErrorState.value,
                label = {
                    Text(text = "Confirm Password*")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        cPasswordVisibility.value = !cPasswordVisibility.value
                    }) {
                        Icon(
                            imageVector = if (cPasswordVisibility.value) Icons.Default.CheckCircle else Icons.Default.Check,
                            contentDescription = "visibility",
                            tint = MaterialTheme.colors.primary
                        )
                    }
                },
                visualTransformation = if (cPasswordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
            )
            if (confirmPasswordErrorState.value) {
                val msg = if (confirmPassword.value.text.isEmpty()) {
                    "Required"
                } else if (confirmPassword.value.text != password.value.text) {
                    "Password not matching"
                } else {
                    ""
                }
                Text(text = msg, color = MaterialTheme.colors.primary)
            }
            Spacer(Modifier.size(16.dp))
            Button(
                onClick = {
                    when {
                        name.value.text.isEmpty() -> {
                            nameErrorState.value = true
                        }
                        email.value.text.isEmpty() -> {
                            emailErrorState.value = true
                        }
                        password.value.text.isEmpty() -> {
                            passwordErrorState.value = true
                        }
                        confirmPassword.value.text.isEmpty() -> {
                            confirmPasswordErrorState.value = true
                        }
                        confirmPassword.value.text != password.value.text -> {
                            confirmPasswordErrorState.value = true
                        }
                        else -> {
                            Toast.makeText(
                                context,
                                "Registered successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.navigate("login_screen") {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    }
                },
                content = {
                    Text(text = "Register", color = Color.White)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
            )
            Spacer(Modifier.size(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = {
                    navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "Login", color = MaterialTheme.colors.primary)
                }
            }
        }
    }
}