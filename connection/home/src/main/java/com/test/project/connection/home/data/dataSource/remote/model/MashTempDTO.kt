package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.MashTemp

data class MashTempDTO(
    val duration: Int?,
    val temp: TempDTOX?
){

    /** */
    fun toEntity():MashTemp =
        MashTemp(
            duration = duration,
            temp = temp?.toEntity()
        )

}