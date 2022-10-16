package com.example.mbcetslipapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mbcetslipapp.R
import com.example.mbcetslipapp.SlipHome
import com.example.mbcetslipapp.ui.theme.ListSlipViewModel
import com.example.mbcetslipapp.ui.theme.MBCETSlipAppTheme

@Composable
fun EnterUserName(listSlipViewModel: ListSlipViewModel, onChange: (String) -> Unit) {
    var username by remember { mutableStateOf(listSlipViewModel.uiState.value.userName) }
    OutlinedTextField(
        value = username,
        onValueChange = { username = it
                        onChange},
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
            unfocusedBorderColor = MaterialTheme.colors.onBackground
        ),
    )
}

@Composable
fun EnterPassword() {
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
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
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
fun LoginButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.size(150.dp, 48.dp),
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
fun ForgotPasswordButton() {
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
fun SignUpButton(navController: NavController) {
    TextButton(
        onClick = { navController.navigate("register_screen") {
            popUpTo("login")
        } },
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.background)
    ) {
        Text(
            text = stringResource(R.string.sign_up_prompt),
            fontSize = 16.sp
        )
    }
}

@Composable
fun Login(listSlipViewModel: ListSlipViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable(
            "login",
            content = { LoginPage(navController, listSlipViewModel, {listSlipViewModel.setUser(it.orEmpty())}) }
        )
        composable(
            "register_screen",
            content = { LoginAndRegistration() }
        )
        composable(
            "home",
            content = { SlipHome(listSlipViewModel) }
        )
    })
}


@Composable
fun LoginPage(navController: NavController, listSlipViewModel: ListSlipViewModel, onChange: (String?) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.frame_99__1_),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )

        Spacer(modifier = Modifier.height(72.dp))
        EnterUserName(listSlipViewModel,
            onChange = onChange
        )

        Spacer(modifier = Modifier.height(24.dp))
        EnterPassword()

        Spacer(modifier = Modifier.height(32.dp))
        LoginButton(navController)

        Spacer(modifier = Modifier.height(32.dp))

        ForgotPasswordButton()
        SignUpButton(navController)

        Spacer(modifier = Modifier.height(128.dp))
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    MBCETSlipAppTheme() {
//        LoginPage()
//    }
//}