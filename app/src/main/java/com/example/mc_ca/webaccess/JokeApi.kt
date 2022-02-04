package com.example.mc_ca.webaccess

import com.example.mc_ca.data.JokeEntity
import retrofit2.http.GET

interface JokeApi {

    //endpoint of the api to get the joke data. Base url of api endpoint is defined in constants
    //data got from api is given to getJokes
    @GET("random/type/general/50")
    suspend fun getJokes() : List<JokeEntity>
}
