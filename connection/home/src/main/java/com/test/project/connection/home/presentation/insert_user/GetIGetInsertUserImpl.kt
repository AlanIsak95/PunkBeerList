package com.test.project.connection.home.presentation.insert_user

import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCase
import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCaseParams

class GetIGetInsertUserImpl  (
    private val insertUserUseCase: InsertUserUseCase
) : IGetInsertUser {

    override suspend fun insertUser(user: InsertUserUseCaseParams) =
        insertUserUseCase.insertUser(user)

}