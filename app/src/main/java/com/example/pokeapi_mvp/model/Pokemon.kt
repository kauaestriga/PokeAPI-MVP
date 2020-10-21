package com.example.pokeapi_mvp.model

import com.squareup.moshi.Json

data class Pokemon(
    val name: String,
    val sprites: Sprites
)

data class Sprites(
    val other: Other
)

data class Other(
    @Json(name = "official-artwork")
    val artwork: Artwork
)

data class Artwork(
    val front_default: String
)