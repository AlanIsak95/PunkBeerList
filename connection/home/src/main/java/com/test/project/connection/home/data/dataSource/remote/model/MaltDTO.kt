package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Malt

data class MaltDTO(
    val amount: AmountDTOX?,
    val name: String?
){

    /** */
    fun toEntity():Malt =
        Malt(
            amount = amount?.toEntity(),
            name = name
        )

}