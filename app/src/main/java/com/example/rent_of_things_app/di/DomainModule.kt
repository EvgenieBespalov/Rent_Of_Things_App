package com.example.rent_of_things_app.di

import com.example.rent_of_things_app.data.api.ProductApi
import com.example.rent_of_things_app.data.converter.ProductConverter
import com.example.rent_of_things_app.data.repository.ProductRepositoryImpl
import com.example.rent_of_things_app.domain.repository.ProductRepository
import com.example.rent_of_things_app.domain.usecase.GetAllProductUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideProductApiRepository(
    productApi: ProductApi,
    converter: ProductConverter
): ProductRepository = ProductRepositoryImpl(productApi, converter)

fun provideDomainModule(): Module =
    module {
        single {
            provideProductApiRepository(
                productApi = get(),
                converter = get()
            )
        }

        factory { GetAllProductUseCase(repository = get()) }
    }