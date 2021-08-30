package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Hop

data class HopDTO(
    val add: String?,
    val amount: AmountDTO?,
    val attribute: String?,
    val name: String?
){
    /** */
    fun toEntity():Hop =
        Hop(
            add = add,
            amount = amount?.toEntity(),
            attribute = attribute,
            name = name
        )
}