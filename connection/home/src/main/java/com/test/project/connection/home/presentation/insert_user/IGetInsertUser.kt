package com.test.project.connection.home.presentation.insert_user

import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCaseParams

interface IGetInsertUser {

    suspend fun insertUser(user: InsertUserUseCaseParams)

}