package com.test.project.connection.home.presentation.get_random_user

import androidx.lifecycle.LiveData
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC

interface IGetRandomUser {

    /* */
    var getRandomUserResponse : GetRandomUserResponseDC

    /** */
    suspend fun getRandomUserAsLiveData():LiveData<ServiceStatus<String?, GetRandomUserResponseDC>>

}