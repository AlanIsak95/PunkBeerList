package com.test.project.connection.home.domain.use_case.insert_user

import com.test.project.connectionTools.database.entities.Person

data class InsertUserUseCaseParams (
    val name : String,
    val password : String,
    val isLogin : Int = 0
){
    fun toPersonEntity():Person=
        Person(
            name = name,
            passWord = password,
            isLogin = isLogin
            )
}