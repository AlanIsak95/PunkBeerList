package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.TempX

data class TempDTOX(
    val unit: String?,
    val value: Int?
){

    /** */
    fun toEntity(): TempX =
        TempX(
            unit = unit,
            value = value
        )

}