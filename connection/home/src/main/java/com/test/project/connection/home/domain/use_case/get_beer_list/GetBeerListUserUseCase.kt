package com.test.project.connection.home.domain.use_case.get_beer_list

import com.test.project.connection.home.domain.IHomeRepository

class GetBeerListUserUseCase(
    private val repository: IHomeRepository
) {
     suspend fun getBeerListByPage() = repository.getBeerListByPage()
}

