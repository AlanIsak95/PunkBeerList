package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Info

data class InfoDTO(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
){

    /** */
    fun toInfo(): Info =
        Info(
            page = page,
            results = results,
            seed = seed,
            version = version
        )

}