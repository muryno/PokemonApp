package com.muryno.pokemonapp.domain.repository

import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.util.Resource

interface PokemonRepository {
    suspend fun getPokemon(id: Long): Resource<Pokemon>?

}