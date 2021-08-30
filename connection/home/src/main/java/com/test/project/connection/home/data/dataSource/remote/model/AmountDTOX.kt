package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.AmountX

data class AmountDTOX(
    val unit: String?,
    val value: Double?
){

    /** */
    fun toEntity():AmountX =
        AmountX(
            unit = unit,
            value = value
        )

}