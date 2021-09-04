package com.muryno.pokemonapp.presenterTest

import com.muryno.pokemonapp.FakePokemonData
import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.util.Resource
import com.muryno.pokemonapp.domain.repository.PokemonRepository


class UseCaseRepositoryMock : PokemonRepository {
    override suspend fun getPokemon(id: Long): Resource<Pokemon>? {
        val dummyData: Pokemon = FakePokemonData.pokemonFakeResponse
        return Resource.Success(dummyData)
    }
}