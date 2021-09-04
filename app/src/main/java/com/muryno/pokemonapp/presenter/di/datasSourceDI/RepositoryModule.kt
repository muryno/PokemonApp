package com.muryno.pokemonapp.presenter.di.datasSourceDI

import com.muryno.pokemonapp.data.repository.PokemonRepositoryImpl
import com.muryno.pokemonapp.data.repository.datasource.PokemonRemoteDataSource
import com.muryno.pokemonapp.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providerRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource,

        ): PokemonRepository {
        return PokemonRepositoryImpl(
            pokemonRemoteDataSource = pokemonRemoteDataSource,
        )
    }


}