package com.example.redfinapp.di

import com.example.redfinapp.data.PropertyRepository
import com.example.redfinapp.data.PropertyRepositoryImpl
import com.example.redfinapp.ui.screens.HomeViewModel
import com.example.redfinapp.ui.screens.PropertyDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<PropertyRepository> { PropertyRepositoryImpl() }
    viewModel { HomeViewModel(get()) }
    viewModel { PropertyDetailViewModel(get()) }
}
