package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_beer_list.Temp

data class TempDTO(
    val unit: String?,
    val value: Int?
){

    /** */
    fun toEntity(): Temp =
        Temp(
            unit = unit,
            value = value
        )

}