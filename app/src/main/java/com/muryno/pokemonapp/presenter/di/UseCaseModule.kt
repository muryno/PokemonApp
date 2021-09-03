package com.muryno.pokemonapp.presenter.di

import com.muryno.pokemonapp.domain.UseCase.GetPokemonUseCase
import com.muryno.pokemonapp.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetUsedCase(pokemonRepository: PokemonRepository) =
        GetPokemonUseCase(pokemonRepository)
}