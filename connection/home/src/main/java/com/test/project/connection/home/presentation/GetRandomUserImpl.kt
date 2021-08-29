package com.test.project.connection.home.presentation

import androidx.lifecycle.*
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow


class GetRandomUserImpl (
    private val getRandomUserUseCase: GetRandomUserUseCase
) : IGetRandomUser{

    /*
     -usar solo cuando se necesite usar la info en varios lados pero no es necesario guardar en DB
     -solo vivirá en cache
    */
    override lateinit var getRandomUserResponse: GetRandomUserResponseDC


    /** */
    override fun getRandomUserAsLiveData() =
        flow<ServiceStatus<String?,GetRandomUserResponseDC>> {
            emit(ServiceStatus.Loading())
            val getRandomUserCaseResponse = getRandomUserUseCase.getRandomUser()
            if (getRandomUserCaseResponse.failure.isNullOrBlank())
                emit(ServiceStatus.Done(getRandomUserCaseResponse))
            else
                emit(ServiceStatus.Failed(getRandomUserCaseResponse.failure))

        }.asLiveData(Dispatchers.IO)

}