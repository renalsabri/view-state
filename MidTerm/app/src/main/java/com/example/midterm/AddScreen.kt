package com.example.midterm

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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midterm.ui.theme.MidTermTheme

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    onRegisterClicked: (id: String, name: String) -> Unit,
    onBackClicked: () -> Unit
) {
    var studentId by rememberSaveable { mutableStateOf("") }
    var studentName by rememberSaveable { mutableStateOf("") }
    var studentPhone by rememberSaveable { mutableStateOf("") }
    var studentAddress by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add new student",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text("Student ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Student Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = studentPhone,
            onValueChange = { studentPhone = it },
            label = { Text("Student phone") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = studentAddress,
            onValueChange = { studentAddress = it },
            label = { Text("Student Adress") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = {
                if (studentId.isNotBlank() && studentName.isNotBlank()) {
                    onRegisterClicked(studentId, studentName)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { onBackClicked() }) {
            Text("Back to Dashboard")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    MidTermTheme {
        AddScreen(onRegisterClicked = { _, _ -> }, onBackClicked = {})
    }
}