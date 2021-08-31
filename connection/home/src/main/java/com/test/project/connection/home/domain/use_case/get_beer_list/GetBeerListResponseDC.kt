package com.test.project.connection.home.domain.use_case.get_beer_list

import com.test.project.connection.home.domain.entity.get_beer_list.BeerResponseItem

data class GetBeerListResponseDC(
    val listBeer: List<BeerResponseItem?>? = null,
    val failure : String? = null
)
