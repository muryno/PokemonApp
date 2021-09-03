package com.muryno.pokemonapp.data.repository.datasource


import com.muryno.pokemonapp.data.model.Pokemon
import retrofit2.Response

interface PokemonRemoteDataSource {
    suspend fun getPokemonFromApi(id: Long): Response<Pokemon>
}