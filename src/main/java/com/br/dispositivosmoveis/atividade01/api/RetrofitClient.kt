package com.br.dispositivosmoveis.atividade01.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api-estudos.vercel.app/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    object ApiClient {
        val apiEndpoint: ApiEndpoint by lazy {
            RetrofitClient.retrofit.create(ApiEndpoint::class.java)
        }
    }
}