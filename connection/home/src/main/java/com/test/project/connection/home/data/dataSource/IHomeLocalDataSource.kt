package com.test.project.connection.home.data.dataSource

import androidx.lifecycle.LiveData
import com.test.project.connection.home.domain.use_case.login.LoginUseCaseParams
import com.test.project.connectionTools.database.entities.Favorite
import com.test.project.connectionTools.database.entities.Person

interface IHomeLocalDataSource {

    /** */
    suspend fun getListOfUser() : LiveData<List<Person>>

    /** */
    suspend fun insertUser(user : Person)

    /** */
    suspend fun validateDataForLogin(params : LoginUseCaseParams):List<Person>

    /** */
    suspend fun insertFavorite(favorite : Favorite)

    /** */
    suspend fun getAllFavorites():List<Favorite>

}