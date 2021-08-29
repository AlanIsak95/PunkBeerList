package com.test.project.connection.home.domain

import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC

interface IHomeRepository {

    /* */
    suspend fun getRandomUser() : GetRandomUserResponseDC

}