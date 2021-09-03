package com.muryno.pokemonapp.domain.UseCase

import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.util.Resource
import com.muryno.pokemonapp.domain.repository.PokemonRepository
import javax.inject.Inject


class GetPokemonUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend fun execute(id : Long): Resource<Pokemon>? = pokemonRepository.getPokemon(id)

}