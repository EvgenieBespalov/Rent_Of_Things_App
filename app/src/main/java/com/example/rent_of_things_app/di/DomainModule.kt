package com.example.rent_of_things_app.di

import android.content.SharedPreferences
import com.example.rent_of_things_app.data.api.ProductApi
import com.example.rent_of_things_app.data.api.ProductTypeApi
import com.example.rent_of_things_app.data.api.UserApi
import com.example.rent_of_things_app.data.converter.ProductConverter
import com.example.rent_of_things_app.data.converter.ProductTypeConverter
import com.example.rent_of_things_app.data.converter.UserConverter
import com.example.rent_of_things_app.data.repository.ProductRepositoryImpl
import com.example.rent_of_things_app.data.repository.ProductTypeRepositoryImpl
import com.example.rent_of_things_app.data.repository.UserRepositoryImpl
import com.example.rent_of_things_app.domain.repository.ProductRepository
import com.example.rent_of_things_app.domain.repository.ProductTypeRepository
import com.example.rent_of_things_app.domain.repository.UserRepository
import com.example.rent_of_things_app.domain.usecase.*
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideProductApiRepository(
    productApi: ProductApi,
    converter: ProductConverter
): ProductRepository = ProductRepositoryImpl(productApi, converter)

private fun provideUserApiRepository(
    userApi: UserApi,
    converter: UserConverter,
    sharedPreferences: SharedPreferences
): UserRepository = UserRepositoryImpl(userApi, converter, sharedPreferences)

private fun provideProductTypeRepositoryImpl(
    productTypeApi: ProductTypeApi,
    converter: ProductTypeConverter
): ProductTypeRepository = ProductTypeRepositoryImpl(productTypeApi, converter)

fun provideDomainModule(): Module =
    module {
        single {
            provideProductApiRepository(
                productApi = get(),
                converter = get()
            )
        }

        single {
            provideUserApiRepository(
                userApi = get(),
                converter = get(),
                sharedPreferences = get()
            )
        }

        single {
            provideProductTypeRepositoryImpl(
                productTypeApi = get(),
                converter = get(),
            )
        }

        factory { GetAllProductUseCase(repository = get()) }
        factory { GetIdProductUseCase(repository = get()) }
        factory { RegistrationUserUseCase(repository = get()) }
        factory { AuthorizationUserUseCase(repository = get()) }
        factory { GetProductTypeUseCase(repository = get()) }
    }