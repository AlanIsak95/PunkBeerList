package com.test.project.connection.home.data.dataSource

import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC

internal interface IHomeRemoteDataSource {

    /** */
    suspend fun getRandomUser() : GetRandomUserResponseDC

}