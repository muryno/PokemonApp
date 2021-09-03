package com.muryno.pokemonapp.presenter.di.datasSourceDI

import com.muryno.pokemonapp.data.api.PokemonService
import com.muryno.pokemonapp.data.repository.datasource.PokemonRemoteDataSource
import com.muryno.pokemonapp.data.repository.datasourceImpl.PokemonRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class PokemonRemoteDataModuleDI {

    @Singleton
    @Provides
    fun providersRemoteDataSource(pokemonService: PokemonService): PokemonRemoteDataSource {
        return PokemonRemoteDataSourceImpl(
            pokemonService
        )
    }

}