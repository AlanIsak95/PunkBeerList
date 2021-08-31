package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_beer_list.Volume

data class VolumeDTO(
    val unit: String?,
    val value: Int?
){

    /** */
    fun toEntity():Volume =
        Volume(
            unit = unit,
            value = value
        )

}