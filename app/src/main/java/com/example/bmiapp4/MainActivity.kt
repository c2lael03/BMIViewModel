package com.example.bmiapp4
// package com.example.testiapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmiapp4.ui.theme.BMIViewModel

/*
data class BmiState(
    val weight: String = "",
    val height: String = "",
    val bmi: Float = 0f
)
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMIApp()
        }
    }
}


@Composable
fun BMIApp() {
    val BMIViewModel: BMIViewModel = BMIViewModel()
    //val (bmiState, setBmiState) = mutableStateOf(BmiState()) // Use BmiState for data management
    //val ViewModel = ViewModel<BMIViewModel>() // Luo ViewModel-instanssi

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp) // Add spacing between elements
        ) {

            Text(
                text = "Body Mass Index",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom=16.dp)
                //style = MaterialTheme.typography.h5
            )

            OutlinedTextField(
                //value = bmiState.weight,
                //onValueChange = { setBmiState(bmiState.copy(weight = it)) }, // Update weight in BmiState
                value = BMIViewModel.weight.value,
                onValueChange = { BMIViewModel.onWeightChange(it) },
                label = { Text("Paino (kg)") },
                modifier = Modifier.fillMaxWidth()
            )

            // Add another TextField for height input (similar structure)
            OutlinedTextField(
                //value = bmiState.height,
                //onValueChange = { setBmiState(bmiState.copy(height = it)) }, // Update weight in BmiState
                value = BMIViewModel.height.value,
                onValueChange = { BMIViewModel.onHeightChange(it) },
                label = { Text("Pituus (cm)") },
                modifier = Modifier.fillMaxWidth()
            )

            /*
            Button(onClick = { ViewModel.calculateBMI() })
                Text("Laske BMI")
            }
             */

            Text(
                text = "Sinun BMI-arvosi on ${"%.2f".format(BMIViewModel.bmi.value)}",
                //text = "Sinun BMI-arvosi on ${BMIViewModel.bmi.value}",
                fontSize = 16.sp,
                //color = MaterialTheme.colorScheme.primary,
                //textAlign = TextAlign.Center,
                //modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom=16.dp)
                //style = MaterialTheme.typography.h6,
            )
        }
    }
}
