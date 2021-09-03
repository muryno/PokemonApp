package com.muryno.pokemonapp.data.repository.datasourceImpl

import com.muryno.pokemonapp.data.api.PokemonService
import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.repository.datasource.PokemonRemoteDataSource
import retrofit2.Response

class PokemonRemoteDataSourceImpl(
    private val pokemonService: PokemonService,
) : PokemonRemoteDataSource {
    override suspend fun getPokemonFromApi(id: Long): Response<Pokemon> =
        pokemonService.getPokemonApi(id)
}

