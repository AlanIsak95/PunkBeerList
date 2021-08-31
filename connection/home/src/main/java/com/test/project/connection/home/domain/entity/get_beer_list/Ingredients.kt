package com.test.project.connection.home.domain.entity.get_beer_list

data class Ingredients(
    val hops: List<Hop>?,
    val malt: List<Malt>?,
    val yeast: String?
)