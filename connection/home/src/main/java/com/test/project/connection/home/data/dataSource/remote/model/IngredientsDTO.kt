package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Ingredients

data class IngredientsDTO(
    val hops: List<HopDTO>?,
    val malt: List<MaltDTO>?,
    val yeast: String?
){

    /** */
    fun toEntity():Ingredients =
        Ingredients(
            hops = hops?.map { it.toEntity() },
            malt = malt?.map { it.toEntity() },
            yeast = yeast
        )

}