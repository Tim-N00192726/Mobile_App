package com.example.mc_ca.webaccess

import com.example.mc_ca.WEB_SERVICE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {

    private val retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        Retrofit.Builder()
            .baseUrl(WEB_SERVICE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    val api: JokeApi by lazy {
        retrofit.create(JokeApi::class.java)
    }
}