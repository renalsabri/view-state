package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midterm.ui.theme.MidTermTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MidTermTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    var currentScreen by rememberSaveable { mutableStateOf("login") }

                    when (currentScreen) {
                        "login" -> {
                            LoginScreen(
                                modifier = Modifier.padding(innerPadding),
                                onLoginClicked = {
                                    currentScreen = "dashboard"
                                }
                            )
                        }

                        "dashboard" -> {
                            DashboardScreen(
                                students = sampleStudentList,
                                modifier = Modifier.padding(innerPadding),
                                onBackClicked = {
                                    currentScreen = "login"
                                },
                                onAddClicked = {
                                    currentScreen = "add"
                                }
                            )
                        }

                        "add" -> {
                            AddScreen(
                                modifier = Modifier.padding(innerPadding),
                                onRegisterClicked = { id, name ->
                                    currentScreen = "dashboard"
                                },
                                onBackClicked = {
                                    currentScreen = "dashboard"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClicked: () -> Unit
) {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var loginError by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Sign in to continue",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                loginError = false
            },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = loginError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                loginError = false
            },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = loginError,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        if (loginError) {
            Text(
                text = "Invalid Username/Password",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (username == "renalsabri123" && password == "renalsabri") {
                    loginError = false
                    onLoginClicked()
                } else {
                    loginError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MidTermTheme {
        LoginScreen(onLoginClicked = {})
    }
}