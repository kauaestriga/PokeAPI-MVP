package com.example.pokeapi_mvp.data.network

import com.example.pokeapi_mvp.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/api/v2/pokemon/{pokemon}")
    fun pesquisar(@Path("pokemon") pokemon: String): Call<Pokemon>

}