package com.test.project.connection.home.data.dataSource.remote

import com.test.project.connection.home.data.dataSource.IHomeRemoteDataSource
import com.test.project.connection.home.data.dataSource.remote.service.HomeApiService
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC
import com.test.project.connection.home.extension.toEntity
import com.test.project.connectionTools.httpClient.retrofit.retrofitApiCall

internal class HomeRemoteDataSourceImpl(
    private val apiService: HomeApiService
) : IHomeRemoteDataSource {

    // TODO: 27/08/2021 change implementation

    override suspend fun getBeerListByPage(): GetRandomUserResponseDC =
        try {
            GetRandomUserResponseDC(listBeer = retrofitApiCall {
                apiService.getBeerListByPage(page = 1)
            }.toEntity())
        }catch (e: Exception){
            GetRandomUserResponseDC(null,"parcelable error : ${e.message}")
        }

}