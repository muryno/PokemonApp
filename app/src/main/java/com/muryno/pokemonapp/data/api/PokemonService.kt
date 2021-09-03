package com.muryno.pokemonapp.data.api


import com.muryno.pokemonapp.data.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{id}")
    suspend fun getPokemonApi(@Path("id")  id: Long): Response<Pokemon>

}