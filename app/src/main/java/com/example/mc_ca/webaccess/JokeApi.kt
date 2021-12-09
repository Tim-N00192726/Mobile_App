package com.example.mc_ca.webaccess

import com.example.mc_ca.data.JokeEntity
import retrofit2.http.GET

interface JokeApi {

    @GET("random/type/general/50")
    suspend fun getJokes() : List<JokeEntity>
}
