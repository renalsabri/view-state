package com.example.midterm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midterm.ui.theme.MidTermTheme

data class Student(
    val id: String,
    val name: String
)

val sampleStudentList = listOf(
    Student("1313623001", "Charen"),
    Student("1313623002", "Farhan"),
    Student("1313623003", "Dimas"),
    Student("1313623004", "Nerassa"),
    Student("1313623005", "Verena")
)

@Composable
fun DashboardScreen(
    students: List<Student>,
    onBackClicked: () -> Unit,
    onAddClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Student Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(students) { student ->
                StudentItemRow(student = student)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onAddClicked() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("+")
        }

        Button(
            onClick = { onBackClicked() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Logout")
        }
        Spacer(modifier = Modifier.height(8.dp))


    }
}

@Composable
fun StudentItemRow(
    student: Student,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = " ${student.id}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = student.name,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    MidTermTheme {
        DashboardScreen(
            students = sampleStudentList,
            onBackClicked = {},
            onAddClicked = {} 
        )
    }
}