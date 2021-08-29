package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Timezone

internal data class TimezoneDTO(
    val description: String?,
    val offset: String?
){
    /** */
    fun toTimeZone():Timezone =
        try {
            Timezone(
                description = description?:"",
                offset = offset?:""
            )
        }catch (e : Exception){
            Timezone(
                description = "",
                offset = ""
            )
        }
}