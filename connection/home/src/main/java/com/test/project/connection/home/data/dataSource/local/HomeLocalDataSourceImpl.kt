package com.test.project.connection.home.data.dataSource.local

import androidx.lifecycle.LiveData
import com.test.project.connection.home.data.dataSource.IHomeLocalDataSource
import com.test.project.connection.home.domain.use_case.login.LoginUseCaseParams
import com.test.project.connectionTools.database.AppDataBase
import com.test.project.connectionTools.database.entities.Favorite
import com.test.project.connectionTools.database.entities.Person
import com.test.project.resources.presentation.extensions.toBase64

internal class HomeLocalDataSourceImpl (
    private val db: AppDataBase
): IHomeLocalDataSource {

    /** */
    override suspend fun getListOfUser(): LiveData<List<Person>> =
        db.personDao().getAll()

    /** */
    override suspend fun insertUser(user: Person) =
        db.personDao().insertPerson(user)

    /** */
    override suspend fun validateDataForLogin(params: LoginUseCaseParams):List<Person> =
        db.personDao().validateDataForLogin(user = params.name , password = params.password.toBase64())

    /** */
    override suspend fun insertFavorite(favorite: Favorite) {
        db.favoriteDao().insertFavorite(favorite)
    }

    /** */
    override suspend fun getAllFavorites(): List<Favorite> =
        db.favoriteDao().getAllFavorites()



}