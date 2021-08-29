package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Street

internal data class StreetDTO(
    val name: String?,
    val number: Int?
){

    /** */
    fun toStreet():Street =
        try {
            Street(
                name = name?:"",
                number = number?:0
            )
        }catch (e :Exception){
            Street(
                name = "",
                number = 0
            )
        }


}