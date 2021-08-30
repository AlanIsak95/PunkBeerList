package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.BoilVolume

data class BoilVolumeDTO(
    val unit: String?,
    val value: Int?
){
    /** */
    fun toEntity():BoilVolume =
        BoilVolume(
            unit = unit,
            value = value
        )
}