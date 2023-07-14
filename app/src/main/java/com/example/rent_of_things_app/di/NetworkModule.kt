package com.example.rent_of_things_app.di

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import com.example.rent_of_things_app.data.api.ProductApi
import com.example.rent_of_things_app.data.api.ProductTypeApi
import com.example.rent_of_things_app.data.api.UserApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException
import java.util.concurrent.TimeUnit


private const val BASE_URL = "http://158.160.49.16:8080/"
private const val CONNECT_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L

private fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder()
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(ReceivedCookiesInterceptor())
        .build()



private fun provideGson(): Gson =
    GsonBuilder()
        .create()

class ReceivedCookiesInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val request = chain.request()
        var response = chain.proceed(request)

        //Log.i(TAG, "request: "+ request.toString())
        //Log.i(TAG, "response: "+ response.toString())

        if (response.code == 401 && request.url.toString() == BASE_URL + "renting/login"){
            val cookie = response.headers("Set-Cookie").get(0)

            response.close()

            val newRequest = chain.request().newBuilder()
                .addHeader("Cookie", cookie)
                .build()

            response = chain.proceed(newRequest)

            //Log.i(TAG, "request: "+ newRequest.toString())
            //Log.i(TAG, "response: "+ response.toString())

            return response
        }

        return response
    }
}

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