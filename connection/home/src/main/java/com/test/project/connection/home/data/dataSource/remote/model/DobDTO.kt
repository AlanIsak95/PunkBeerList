package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Dob

internal data class DobDTO(
    val age: Int?,
    val date: String?
){
    /** */
    fun toDob():Dob =
        try {
            Dob(
                age = age?:0,
                date = date?:""
            )
        }catch (e:Exception){
            Dob(
                age = 0,
                date = ""
            )
        }

}