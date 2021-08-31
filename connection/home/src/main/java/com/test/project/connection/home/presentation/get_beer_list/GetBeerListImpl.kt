package com.test.project.connection.home.presentation.get_beer_list

import androidx.lifecycle.*
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.domain.use_case.get_beer_list.GetBeerListResponseDC
import com.test.project.connection.home.domain.use_case.get_beer_list.GetBeerListUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow


class GetBeerListImpl (
    private val getBeerListUserUseCase: GetBeerListUserUseCase
) : IGetBeerList {

    /*
     -usar solo cuando se necesite usar la info en varios lados pero no es necesario guardar en DB
     -solo vivirá en cache
    */
    override lateinit var getBeerListResponse: GetBeerListResponseDC


    /** */
    override suspend fun getBeerListByPageAsLiveData(page : Int) =
        flow<ServiceStatus<String?,GetBeerListResponseDC>> {
            emit(ServiceStatus.Loading())
            val getRandomUserCaseResponse = getBeerListUserUseCase.getBeerListByPage(page = page)
            if (getRandomUserCaseResponse.failure.isNullOrBlank())
                emit(ServiceStatus.Done(getRandomUserCaseResponse))
            else
                emit(ServiceStatus.Failed(getRandomUserCaseResponse.failure))

        }.asLiveData(Dispatchers.IO)

}