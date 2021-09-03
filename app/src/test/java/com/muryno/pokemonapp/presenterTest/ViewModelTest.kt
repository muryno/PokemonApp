package com.muryno.pokemonapp.presenterTest

import android.app.Application
import com.google.common.truth.Truth.assertThat
import com.muryno.pokemonapp.domain.UseCase.GetPokemonUseCase
import com.muryno.pokemonapp.presenter.viewModel.PokemonViewModel
import com.muryno.pokemonapp.utils.BaseUnitTest
import com.muryno.pokemonapp.utils.getOrAwaitValueTest
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

@HiltAndroidTest
@ExperimentalCoroutinesApi
class ViewModelTest : BaseUnitTest() {

    @Mock
    private lateinit var appContext: Application
    lateinit var pokemonViewModel: PokemonViewModel

    @Before
    fun setUp() {
        appContext = Application()
        pokemonViewModel = PokemonViewModel(  GetPokemonUseCase(
            UseCaseRepositoryMock()
        )
        )
    }

    @Test
        fun TestWhenPokemonDataIsFetchedLiveData() = runBlocking {
        pokemonViewModel.getPokemonLiveData(1)
        pokemonViewModel.pokemonLiveData.value = UseCaseRepositoryMock().getPokemon(1)
        val value = pokemonViewModel.pokemonLiveData.getOrAwaitValueTest()
        assertThat(value.data?.name).isEqualTo(
            "muraino"
        )
    }


}