package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.GetRandomUserResponse

internal data class GetRandomUserResponseDTO(
    val info: InfoDTO?,
    val results: List<ResultDTO>?
){
    /** */
    fun toRandomUserResponse(): GetRandomUserResponse =
        GetRandomUserResponse(
            info = info?.toInfo(),
            results = results?.map { it.toResult() }
            )
}

