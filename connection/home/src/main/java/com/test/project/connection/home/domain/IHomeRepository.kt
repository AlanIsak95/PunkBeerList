package com.test.project.connection.home.domain

import androidx.lifecycle.LiveData
import com.test.project.connection.home.data.dataSource.local.models.PersonToPresentation
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC
import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCaseParams
import com.test.project.connection.home.domain.use_case.login.LoginUseCaseParams
import com.test.project.connectionTools.database.entities.Person

interface IHomeRepository {

    /**REMOTE*/

    /** */
    suspend fun getRandomUser() : GetRandomUserResponseDC



    /**LOCAL*/

    /** */
    suspend fun getListOfUser() : LiveData<List<Person>>
    /** */
    suspend fun insertUser(user : InsertUserUseCaseParams)

    /** */
    suspend fun validateDataForLogin(params : LoginUseCaseParams):LiveData<ArrayList<PersonToPresentation?>>

}