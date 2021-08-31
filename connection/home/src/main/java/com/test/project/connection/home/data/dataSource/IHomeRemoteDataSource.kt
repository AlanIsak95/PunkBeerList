package com.test.project.connection.home.data.dataSource

import com.test.project.connection.home.domain.use_case.get_beer_list.GetBeerListResponseDC

internal interface IHomeRemoteDataSource {

    /** */
    suspend fun getBeerListByPage(page : Int) : GetBeerListResponseDC

}