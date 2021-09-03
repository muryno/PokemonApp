package com.muryno.pokemonapp.data.model

data class Pokemon(
    val id: Int,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val stats: List<Stat>,
)