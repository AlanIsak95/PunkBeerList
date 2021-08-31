package com.test.project.connection.home.presentation.get_beer_list

import androidx.lifecycle.LiveData
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.domain.use_case.get_beer_list.GetBeerListResponseDC

interface IGetBeerList {

    /* */
    var getBeerListResponse : GetBeerListResponseDC

    /** */
    suspend fun getBeerListByPageAsLiveData(page : Int):LiveData<ServiceStatus<String?, GetBeerListResponseDC>>

}