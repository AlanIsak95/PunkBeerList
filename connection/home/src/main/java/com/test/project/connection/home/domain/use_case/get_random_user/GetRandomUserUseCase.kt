package com.test.project.connection.home.domain.use_case.get_random_user

import com.test.project.connection.home.domain.IHomeRepository

class GetRandomUserUseCase(
    private val repository: IHomeRepository
) {
     suspend fun getRandomUser() = repository.getRandomUser()
}

