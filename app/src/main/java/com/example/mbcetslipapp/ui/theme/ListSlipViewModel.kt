package com.example.mbcetslipapp.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListSlipViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SlipUiState())
    val uiState: StateFlow<SlipUiState> = _uiState.asStateFlow()
    init {
        resetGame()
    }
    fun resetGame() {
        _uiState.value = SlipUiState(userType = "Student", selection = "Requested")
    }
    fun updateUserType(type: String)
    {
        val selection = _uiState.value.selection
        _uiState.value = SlipUiState(type,selection)
    }
    fun updateSelection(type: String)
    {
        val user = _uiState.value.userType
        _uiState.value = SlipUiState(user,type)
    }
    fun setUser(userName: String)
    {
        _uiState.value = SlipUiState(userType = if(userName == "Rick Astley") {"HoD"} else {"Student"}, selection = "Requested", userName = userName)
    }
}

fun setUserExtrernal(userName: String, listSlipViewModel: ListSlipViewModel): ListSlipViewModel
{
    listSlipViewModel.setUser(userName)
    return listSlipViewModel
}