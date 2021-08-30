package com.test.project.connection.home.domain.use_case.get_random_user

import com.test.project.connection.home.domain.entity.get_random_user.BeerResponseItem

data class GetRandomUserResponseDC(
    val listBeer: List<BeerResponseItem?>? = null,
    val failure : String? = null
)
