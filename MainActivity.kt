package com.example.firstandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApiScreen()
        }
    }
}

@Composable
fun ApiScreen() {

    var result by remember { mutableStateOf("Press button to load data") }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {

        Button(onClick = {

            CoroutineScope(Dispatchers.IO).launch {

                val response =
                    URL("https://jsonplaceholder.typicode.com/posts/1").readText()

                result = response
            }

        }) {

            Text("Fetch API Data")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(result)
    }
}
