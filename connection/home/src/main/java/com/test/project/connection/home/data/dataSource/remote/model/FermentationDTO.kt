package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Fermentation

data class FermentationDTO(
    val temp: TempDTO?
){

    /** */
    fun toEntity(): Fermentation =
        Fermentation(
            temp = temp?.toEntity()
        )

}