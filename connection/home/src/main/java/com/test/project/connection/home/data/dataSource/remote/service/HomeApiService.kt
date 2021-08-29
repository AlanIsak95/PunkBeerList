package com.test.project.connection.home.data.dataSource.remote.service

import com.test.project.connection.home.data.dataSource.remote.model.GetRandomUserResponseDTO
import retrofit2.Response
import retrofit2.http.GET

internal interface HomeApiService {

@GET(URL.GET_API)
suspend fun getRandomUser() : Response<GetRandomUserResponseDTO>


/* */
private object URL {
    /* */
    const val GET_API = "api/"
}

}