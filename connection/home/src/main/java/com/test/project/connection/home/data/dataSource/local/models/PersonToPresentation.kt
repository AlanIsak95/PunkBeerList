package com.test.project.connection.home.data.dataSource.local.models

import com.test.project.connectionTools.database.entities.Person

/* */
data class PersonToPresentation(
    val name : String,
    val passWord : String,
    val isLogin : Int
){

    /** For Send the info to Layer Presentation */
    companion object {
        fun toDomainEntity(
            dbEntity: Person
        ): PersonToPresentation =
            PersonToPresentation(
                name = dbEntity.name,
                passWord = dbEntity.passWord,
                isLogin = dbEntity.isLogin
            )
    }

}

