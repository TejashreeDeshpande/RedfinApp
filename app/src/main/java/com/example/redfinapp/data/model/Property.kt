package com.example.redfinapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Property(
    val id: String,
    val price: Double,
    val address: String,
    val beds: Int,
    val baths: Double,
    val sqft: Int,
    val imageUrl: String,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val yearBuilt: Int,
    val propertyType: String
)
