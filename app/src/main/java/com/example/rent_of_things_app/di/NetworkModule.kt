package com.example.rent_of_things_app.di

import com.example.rent_of_things_app.data.api.ProductApi
import com.example.rent_of_things_app.data.api.ProductTypeApi
import com.example.rent_of_things_app.data.api.UserApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


private const val BASE_URL = "http://158.160.107.164:8080/"
private const val CONNECT_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L

private fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder()
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .build()

private fun provideGson(): Gson =
    GsonBuilder()
        .create()

private fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
    Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

private fun provideProductApi(retrofit: Retrofit): ProductApi =
    retrofit.create()

private fun provideUserApi(retrofit: Retrofit): UserApi =
    retrofit.create()

private fun provideProductTypeApi(retrofit: Retrofit): ProductTypeApi =
    retrofit.create()

fun provideNetworkModule(): Module =
    module {
        single { provideOkHttpClient() }
        single { provideGson() }
        single { provideRetrofit(okHttpClient = get(), gson = get()) }
        single { provideProductApi(retrofit = get()) }
        single { provideUserApi(retrofit = get()) }
        single { provideProductTypeApi(retrofit = get()) }
    }