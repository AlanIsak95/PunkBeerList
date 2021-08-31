package com.test.project.connectionTools.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.test.project.connectionTools.database.entities.Favorite

@Dao
interface FavoriteDao {

    //region Create

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(person: Favorite)
    //endregion

    //region READ
    @Query("SELECT * FROM Favoritos")
    fun getAllFavorites(): LiveData<List<Favorite>>

    //endregion

    //region UPDATE
    @Update
    fun updateFavorite(person: Favorite)

    @Query("UPDATE Favoritos SET rate_value=:price WHERE favorite_id = :id")
    fun setRateBarToFavoriteByID(price: Double, id: Int)

    //endregion

    //region DELETE
    @Query("DELETE FROM Favoritos WHERE favorite_id = :id")
    fun deleteFavorite(id: Int)
    //endregion

}
