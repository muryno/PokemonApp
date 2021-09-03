package com.muryno.pokemonapp

import com.muryno.pokemonapp.data.model.*


object FakePokemonData {

    val pokemonFakeResponse =

        Pokemon(
            id = 1,
            moves = listOf(
                Move(
                    move = MoveX(name = "movie1", url = "http://movie1.com"),
                ),
                Move(
                    move = MoveX(name = "movie2", url = "http://movie2.com"),
                ),
                Move(
                    move = MoveX(name = "movi3", url = "http://movie3.com"),
                ),
            ),
            name = "muraino",
            order = 3,


            sprites = Sprites(
                back_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/1.gif",
                back_female = "null",
                back_shiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/shiny/1.gif",
                back_shiny_female = "null",
                front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif",
                front_female = "null",
                front_shiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/shiny/1.gif",
                front_shiny_female = "null"
            ),
            stats = listOf(
                Stat(
                    base_stat = 9,
                    effort = 3,
                    stat = StatX(name = "statX1", url = "http://movie3.com"),
                ),
                Stat(
                    base_stat = 9,
                    effort = 3,
                    stat = StatX(name = "", url = ""),
                ),
                Stat(
                    base_stat = 9,
                    effort = 3,
                    stat = StatX(name = "", url = ""),
                ),
            ),
        )

}