package com.muryno.pokemonapp.data.repository

import android.util.Log
import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.repository.datasource.PokemonRemoteDataSource
import com.muryno.pokemonapp.data.util.Resource
import com.muryno.pokemonapp.domain.repository.PokemonRepository
import com.muryno.pokemonapp.utils.ResponseToResourceUtils


class PokemonRepositoryImpl(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
) : PokemonRepository {

    override suspend fun getPokemon(id : Long): Resource<Pokemon> {
      return  getPokemonFromAPI(id)
    }



    //Making the network call to pokemon api
    private suspend fun getPokemonFromAPI(id : Long): Resource<Pokemon> {
        return try {
            val response = pokemonRemoteDataSource.getPokemonFromApi(id)
            ResponseToResourceUtils.responseToResource(response, null)
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
            ResponseToResourceUtils.responseToResource(null, exception)
        }

    }
}