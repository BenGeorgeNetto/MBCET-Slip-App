package com.example.mbcetslipapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbcetslipapp.R
import com.example.mbcetslipapp.ui.theme.MBCETSlipAppTheme

@Composable
fun enterUserName() {
    var username by remember { mutableStateOf("") }
    OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon( imageVector = Icons.Filled.Email, contentDescription = null, tint = MaterialTheme.colors.surface )
            }
        },
        shape = RoundedCornerShape(16.dp),
        label = {
            Text(
                text = stringResource(R.string.username_field_default_label),
                fontSize = 24.sp,
                color = MaterialTheme.colors.surface,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.surface
        ),
    )
}

@Composable
fun enterPassword() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon( imageVector = Icons.Filled.Lock, contentDescription = null, tint = MaterialTheme.colors.surface )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                R.drawable.ic_baseline_visibility_24
            else R.drawable.ic_baseline_visibility_off_24
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon( painter = painterResource(id = image) , contentDescription = null, tint = MaterialTheme.colors.surface)
            }
        },
        label = {
            Text(
                text = stringResource(R.string.password_field_default_label),
                fontSize = 24.sp,
                color = MaterialTheme.colors.surface,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.surface,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { /*TODO*/ }
        )
    )
}

@Composable
fun loginButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.size(128.dp, 56.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
    ) {
        Text(
            text = stringResource(R.string.login_button_text),
            fontSize = 24.sp,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun forgotPasswordButton() {
    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.background)
    ) {
        Text(
            text = stringResource(R.string.forgot_password),
            fontSize = 16.sp
        )
    }
}

@Composable
fun loginPage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.templogo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )

        Spacer(modifier = Modifier.height(72.dp))
        enterUserName()

        Spacer(modifier = Modifier.height(24.dp))
        enterPassword()

        Spacer(modifier = Modifier.height(32.dp))
        loginButton()

        forgotPasswordButton()

        Spacer(modifier = Modifier.height(128.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MBCETSlipAppTheme() {
        loginPage()
    }
}