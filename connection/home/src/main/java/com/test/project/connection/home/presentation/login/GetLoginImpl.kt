package com.test.project.connection.home.presentation.login

import androidx.lifecycle.LiveData
import com.test.project.connection.home.data.dataSource.local.models.PersonToPresentation
import com.test.project.connection.home.domain.use_case.login.LoginUseCase
import com.test.project.connection.home.domain.use_case.login.LoginUseCaseParams
import com.test.project.connectionTools.database.entities.Person

class GetLoginImpl  (
    private val loginUseCase: LoginUseCase
) : IGetLogin {
    override suspend fun validateDataForLogin(params: LoginUseCaseParams): LiveData<ArrayList<PersonToPresentation?>> =
        loginUseCase.validateDataForLogin(params = params)
}