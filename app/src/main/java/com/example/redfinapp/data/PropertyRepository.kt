package com.example.redfinapp.data

import com.example.redfinapp.data.model.Property
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface PropertyRepository {
    fun getProperties(): Flow<List<Property>>
    fun getPropertyById(id: String): Flow<Property?>
}

class PropertyRepositoryImpl : PropertyRepository {
    private val mockProperties = listOf(
        Property(
            id = "1",
            price = 750000.0,
            address = "123 Maple Ave, Seattle, WA",
            beds = 3,
            baths = 2.0,
            sqft = 1800,
            imageUrl = "https://images.unsplash.com/photo-1568605114967-8130f3a36994",
            latitude = 47.6062,
            longitude = -122.3321,
            description = "Beautiful modern home in the heart of Seattle featuring an open floor plan, updated kitchen, and a spacious backyard perfect for entertaining.",
            yearBuilt = 2015,
            propertyType = "Single Family"
        ),
        Property(
            id = "2",
            price = 1200000.0,
            address = "456 Pine St, Bellevue, WA",
            beds = 4,
            baths = 3.5,
            sqft = 2800,
            imageUrl = "https://images.unsplash.com/photo-1570129477492-45c003edd2be",
            latitude = 47.6101,
            longitude = -122.2015,
            description = "Spacious luxury estate with stunning mountain views. This home boasts high-end finishes, a gourmet chef's kitchen, and a private master suite.",
            yearBuilt = 2020,
            propertyType = "Estate"
        )
    )

    override fun getProperties(): Flow<List<Property>> = flow {
        emit(mockProperties)
    }

    override fun getPropertyById(id: String): Flow<Property?> = flow {
        emit(mockProperties.find { it.id == id })
    }
}
