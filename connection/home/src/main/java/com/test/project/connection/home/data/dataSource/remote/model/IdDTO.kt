package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Id

internal data class IdDTO(
    val name: String?,
    val value: String?
){
    /** */
    fun toId():Id=
        try {
            Id(
                name = name?:"",
                value = value?:""
            )
        }catch (e:Exception){
            Id(
                name = "",
                value = ""
            )
        }

}