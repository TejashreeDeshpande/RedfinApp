package com.example.redfinapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redfinapp.data.PropertyRepository
import com.example.redfinapp.data.model.Property
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PropertyDetailViewModel(
    private val repository: PropertyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PropertyDetailUiState>(PropertyDetailUiState.Loading)
    val uiState: StateFlow<PropertyDetailUiState> = _uiState.asStateFlow()

    fun fetchProperty(id: String) {
        viewModelScope.launch {
            repository.getPropertyById(id).collect { property ->
                if (property != null) {
                    _uiState.value = PropertyDetailUiState.Success(property)
                } else {
                    _uiState.value = PropertyDetailUiState.Error("Property not found")
                }
            }
        }
    }
}

sealed interface PropertyDetailUiState {
    object Loading : PropertyDetailUiState
    data class Success(val property: Property) : PropertyDetailUiState
    data class Error(val message: String) : PropertyDetailUiState
}
