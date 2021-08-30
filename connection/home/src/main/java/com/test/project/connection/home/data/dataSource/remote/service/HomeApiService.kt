package com.test.project.connection.home.data.dataSource.remote.service

import com.test.project.connection.home.data.dataSource.remote.model.BeerResponseItemDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface HomeApiService {

@GET(URL.BEER)
suspend fun getBeerListByPage(
    @Query("page") page : Int,
    @Query("per_page") per_page : Int = URL.PER_PAGE) : Response<List<BeerResponseItemDTO>>


/* */
private object URL {
    /* */
    const val BEER = "beers"
    /* */
    const val PER_PAGE = 25
}

}