package com.example.bmiapp4.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
//import androidx.lifecycle.Lifecycle
//import com.example.bmiapp4.BmiState

class BMIViewModel : ViewModel() {
    var weight = mutableStateOf("")
        private set

    var height = mutableStateOf("")
        private set

    var bmi = mutableStateOf(0.0)
        private set

    fun onWeightChange(newWeight: String) {
        weight.value = newWeight
        calculateBMI()
    }

    fun onHeightChange(newHeight: String) {
        height.value = newHeight
        calculateBMI()
    }

    private fun calculateBMI() {
        val weightVal = weight.value.toDoubleOrNull() ?: 0.0
        val heightVal = height.value.toDoubleOrNull() ?: 0.0

        bmi.value = if (heightVal > 0) {
            weightVal / (heightVal * heightVal) * 10000
        } else {
            0.0
        }
    }
}