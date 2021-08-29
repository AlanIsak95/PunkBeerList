package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Coordinates

internal data class CoordinatesDTO(
    val latitude: String?,
    val longitude: String?
){

    /** */
    fun toCoordinates():Coordinates =
        try {
            Coordinates(
                latitude = latitude?:"",
                longitude = longitude?:""
            )
        }
        catch (e:Exception){
            Coordinates(
                latitude = "",
                longitude = ""
            )
        }

}