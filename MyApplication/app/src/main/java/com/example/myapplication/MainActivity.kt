package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                QuizApp()

            }
        }
    }
}

@Composable
fun QuizApp(){
    val score = rememberSaveable{mutableStateOf(0)}
    val question = "Is this assignment done perfectly?"
    var feedback by rememberSaveable{ mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEBB))
            .padding(16.dp),
            contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome to Quiz", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(question, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        feedback = "Correct!"
                        score.value++ },
                    shape = RoundedCornerShape(10.dp),
                    colors =ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF006400))
                ) {
                    Text("True")
                }
                Button(
                    onClick = {
                        feedback = "Wrong!"
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors =ButtonDefaults.buttonColors(
                       containerColor = Color(0xFF006400))
                ) {
                    Text("False")
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            Text(feedback, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(18.dp))
            Text("Score: ${score.value}", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }
    }
}
