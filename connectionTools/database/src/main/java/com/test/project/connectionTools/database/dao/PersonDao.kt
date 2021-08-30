package com.test.project.connectionTools.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.test.project.connectionTools.database.entities.Person

@Dao
interface PersonDao {

    //region Create
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfPerson(listOfPerson : List<Person>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)
    //endregion

    //region READ
    @Query("SELECT * FROM Usuarios")
    fun getAll(): LiveData<List<Person>>

    @Query("SELECT * FROM Usuarios WHERE name = :user AND password = :password")
    fun validateDataForLogin(
        user:String,
        password:String
    ): List<Person>

    //endregion

    //region UPDATE
    @Update
    fun updatePerson(person: Person)
    //endregion

    //region DELETE
    @Delete
    fun deletePerson(person: Person)
    //endregion

}