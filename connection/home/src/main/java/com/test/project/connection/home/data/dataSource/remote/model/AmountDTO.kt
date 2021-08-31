package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_beer_list.Amount

data class AmountDTO(
    val unit: String?,
    val value: Double?
){

    /** */
    fun toEntity():Amount =
        Amount(
            unit = unit,
            value = value
        )

}