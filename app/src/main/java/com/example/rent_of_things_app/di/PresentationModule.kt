package com.example.rent_of_things_app.di

import com.example.rent_of_things_app.presentation.ProductListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun providePresentationModule(): Module =
    module {
        viewModel {
            ProductListScreenViewModel()
        }
    }