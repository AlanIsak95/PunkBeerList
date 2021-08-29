package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Registered

internal data class RegisteredDTO(
    val age: Int?,
    val date: String?
){

    /** */
    fun toRegistered():Registered =
        try {
            Registered(
                age = age?:0,
                date = date?:""
            )
        }catch (e : Exception){
            Registered(
                age = 0,
                date = ""
            )
        }

}