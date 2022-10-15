package com.example.mbcetslipapp.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SlipViewModel : ViewModel() {
    var slipType by mutableStateOf(value = "")
    var title by mutableStateOf(value = "")
    var description by mutableStateOf(value = "")
    var sendToHOD by mutableStateOf(value = false)
    var sendToAdvisors by mutableStateOf(value = false)
}
