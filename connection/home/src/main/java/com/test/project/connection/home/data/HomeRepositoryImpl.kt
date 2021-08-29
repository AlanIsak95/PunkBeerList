package com.test.project.connection.home.data

import com.test.project.connection.home.data.dataSource.IHomeRemoteDataSource
import com.test.project.connection.home.domain.IHomeRepository
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC

internal class HomeRepositoryImpl (
    private val remoteDataSource: IHomeRemoteDataSource
):IHomeRepository {

    override suspend fun getRandomUser() : GetRandomUserResponseDC =
        remoteDataSource.getRandomUser()

}