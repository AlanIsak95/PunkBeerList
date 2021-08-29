package com.test.project.connection.home.presentation

import androidx.lifecycle.LiveData
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC

interface IGetRandomUser {

    /* */
    var getRandomUserResponse : GetRandomUserResponseDC

    /** */
    fun getRandomUserAsLiveData():LiveData<ServiceStatus<String?, GetRandomUserResponseDC>>

}