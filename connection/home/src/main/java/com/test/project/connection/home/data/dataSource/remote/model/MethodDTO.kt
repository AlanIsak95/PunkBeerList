package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_beer_list.Method

data class MethodDTO(
    val fermentation: FermentationDTO?,
    val mash_temp: List<MashTempDTO>?,
    val twist: String?
){

    /** */
    fun toEntity(): Method =
        Method(
            fermentation = fermentation?.toEntity(),
            mash_temp = mash_temp?.map { it.toEntity() },
            twist = twist
        )

}