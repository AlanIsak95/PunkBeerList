package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Login

internal data class LoginDTO(
    val md5: String?,
    val password: String?,
    val salt: String?,
    val sha1: String?,
    val sha256: String?,
    val username: String?,
    val uuid: String?
){
    /** */
    fun toLogin():Login =
        try {
            Login(
                md5 = md5?:"",
                password = password?:"",
                salt = salt?:"",
                sha1 = sha1?:"",
                sha256 =sha256?:"",
                username = username?:"",
                uuid = uuid?:""
            )
        }catch (e:Exception){
            Login(
                md5 = "",
                password = "",
                salt = "",
                sha1 = "",
                sha256 ="",
                username = "",
                uuid = ""
            )
        }

}