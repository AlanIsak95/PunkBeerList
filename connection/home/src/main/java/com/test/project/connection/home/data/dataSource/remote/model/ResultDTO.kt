package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Result

internal data class ResultDTO(
    val cell: String?,
    val dob: DobDTO?,
    val email: String?,
    val gender: String?,
    val id: IdDTO?,
    val location: LocationDTO?,
    val login: LoginDTO?,
    val name: NameDTO?,
    val nat: String?,
    val phone: String?,
    val picture: PictureDTO?,
    val registered: RegisteredDTO?
){

    /***/
    fun toResult():Result=
        Result(
            cell = cell?:"",
            dob = dob?.toDob(),
            email = email?:"",
            gender = gender?:"",
            id = id?.toId(),
            location = location?.toLocation(),
            login = login?.toLogin(),
            name = name?.toName(),
            nat = nat?:"",
            phone = phone?:"",
            picture = picture?.toPicture(),
            registered = registered?.toRegistered()
        )

}