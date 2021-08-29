package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Name

internal data class NameDTO(
    val first: String?,
    val last: String?,
    val title: String?
){

    /** */
    fun toName():Name =
        try {
            Name(
                first = first?:"",
                last = last?:"",
                title = title?:""
            )
        }catch (e:Exception){
            Name(
                first = "",
                last = "",
                title = ""
            )
        }


}