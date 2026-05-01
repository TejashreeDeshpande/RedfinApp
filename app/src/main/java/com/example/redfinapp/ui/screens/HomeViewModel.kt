package com.example.redfinapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redfinapp.data.PropertyRepository
import com.example.redfinapp.data.model.Property
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: PropertyRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        fetchProperties()
    }

    private fun fetchProperties() {
        viewModelScope.launch {
            repository.getProperties().collect { properties ->
                _uiState.value = HomeUiState.Success(properties)
            }
        }
    }
}

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val properties: List<Property>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}
