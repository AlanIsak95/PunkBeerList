package com.test.project.connection.home.domain.use_case.login

import androidx.lifecycle.LiveData
import com.test.project.connection.home.data.dataSource.local.models.PersonToPresentation
import com.test.project.connection.home.domain.IHomeRepository


class LoginUseCase (
    private val repository: IHomeRepository
) {
    suspend fun validateDataForLogin(params: LoginUseCaseParams): LiveData<ArrayList<PersonToPresentation?>> =
        repository.validateDataForLogin(params = params)
}
