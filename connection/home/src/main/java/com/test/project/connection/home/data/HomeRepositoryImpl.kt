package com.test.project.connection.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.data.dataSource.IHomeLocalDataSource
import com.test.project.connection.home.data.dataSource.IHomeRemoteDataSource
import com.test.project.connection.home.data.dataSource.local.models.PersonToPresentation
import com.test.project.connection.home.domain.IHomeRepository
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC
import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCaseParams
import com.test.project.connection.home.domain.use_case.login.LoginUseCaseParams
import com.test.project.connectionTools.database.entities.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.flow

internal class HomeRepositoryImpl (
    private val remoteDataSource: IHomeRemoteDataSource,
    private val localDataSource: IHomeLocalDataSource
):IHomeRepository {

//    private var _personListLiveData = MutableLiveData<ArrayList<PersonToPresentation?>>()
//    private val personListLiveData : LiveData<ArrayList<PersonToPresentation?>> get() = _personListLiveData

    override suspend fun getRandomUser() : GetRandomUserResponseDC =
        remoteDataSource.getRandomUser()

    override suspend fun getListOfUser(): LiveData<List<Person>> =
        localDataSource.getListOfUser()

    override suspend fun insertUser(user: InsertUserUseCaseParams) =
        localDataSource.insertUser(user.toPersonEntity())

    override suspend fun validateDataForLogin(params : LoginUseCaseParams): LiveData<ArrayList<PersonToPresentation?>> =
        flow<ArrayList<PersonToPresentation?>> {
           val listOfDataEntity = localDataSource.validateDataForLogin(params = params)
            try {
                emit(
                    arrayListOf(PersonToPresentation.toDomainEntity(
                    listOfDataEntity.first())
                    )
                )

            }catch (e : Exception){
                emit(arrayListOf(null))
            }
        }.asLiveData(Dispatchers.IO)



}