package com.test.project.connection.home.domain.use_case.insert_user

import com.test.project.connection.home.domain.IHomeRepository

class InsertUserUseCase (
    private val repository: IHomeRepository
) {
    suspend fun insertUser(user : InsertUserUseCaseParams) = repository.insertUser(user = user )
}

