package com.muryno.pokemonapp.domainModule


import com.google.common.truth.Truth.assertThat
import com.muryno.pokemonapp.FakePokemonData
import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.util.Resource
import com.muryno.pokemonapp.domain.UseCase.GetPokemonUseCase
import com.muryno.pokemonapp.domain.repository.PokemonRepository
import com.muryno.pokemonapp.utils.BaseUnitTest
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@HiltAndroidTest
@ExperimentalCoroutinesApi
class UseCaseTest : BaseUnitTest() {

    private lateinit var pokemonRepository: PokemonRepository
    private lateinit var getPokemonUseCase: GetPokemonUseCase

    private var pokemon = FakePokemonData.pokemonFakeResponse

    val FETCHID: Long = 1

    @Before
    fun setUp() {
        pokemonRepository = Mockito.mock(PokemonRepository::class.java)
        getPokemonUseCase = GetPokemonUseCase(pokemonRepository)
    }

    @Test
    fun executeCaseNotEqualNullTest() = runBlocking {
        Mockito.`when`(pokemonRepository.getPokemon(FETCHID)).thenReturn(
            Resource.Success(
                pokemon
            )
        )
        val reponse: Resource<Pokemon>? =
            pokemonRepository.getPokemon(FETCHID)
        assertThat(reponse).isNotNull()
    }


}