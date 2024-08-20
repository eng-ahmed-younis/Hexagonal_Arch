package com.base.authentication.presentation.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.base.authentication.presentation.components.LoadingScreen
import com.base.authentication.presentation.screens.login.LoginIntents
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    state: SignUpState,
    sendEvent : (SignUpIntents) -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val name by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val iconVisibility = when (passwordVisible) {
        true -> {
            Icons.Rounded.Visibility
        }

        false -> {
            Icons.Rounded.VisibilityOff
        }
    }
    when{
        state.error != null ->{
            Text(text = state.error)
        }
        state.isLoading ->{
            LoadingScreen()
        }
        state.data != null ->{
            // navigate to login screen
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign Up",
            modifier = Modifier
                .padding(16.dp),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { email = it },
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
        )
        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
        )
        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                // Password visibility toggle
                IconButton(
                    onClick = {
                        /* Handle password visibility toggle */
                        // Please provide localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"
                        passwordVisible = !passwordVisible
                    }
                ) {
                    Icon(
                        imageVector = iconVisibility,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },
        )


        Spacer(modifier = Modifier.padding(30.dp))

        Button(
            onClick = {
                scope.launch {
                    sendEvent(SignUpIntents.SignUpUser(email, password))
                }
            },
            modifier = Modifier
                .width(200.dp)
                .padding(16.dp)

        ) {
            Text("Sign Up")
        }


    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_8_pro")
fun SignUpScreenPreview() {
    SignUpScreen(
        state = SignUpState(),
        sendEvent = {}
    )
}