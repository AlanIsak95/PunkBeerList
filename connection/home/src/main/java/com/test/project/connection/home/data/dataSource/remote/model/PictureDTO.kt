package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Picture

internal data class PictureDTO(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
){

    /** */
    fun toPicture():Picture =
        try {
            Picture(
                large = large?:"",
                medium = medium?:"",
                thumbnail = thumbnail?:""
            )
        }catch (e:Exception){
            Picture(
                large = "",
                medium = "",
                thumbnail = ""
            )
        }


}