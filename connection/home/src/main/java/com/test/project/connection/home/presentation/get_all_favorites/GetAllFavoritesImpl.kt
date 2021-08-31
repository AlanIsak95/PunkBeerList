package com.test.project.connection.home.presentation.get_all_favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.test.project.connection.home.data.dataSource.local.models.FavoriteToPresentation
import com.test.project.connection.home.data.dataSource.local.models.PersonToPresentation
import com.test.project.connection.home.domain.use_case.get_all_favorites.GetFavoriteListUserCase
import com.test.project.connectionTools.database.entities.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow


class GetAllFavoritesImpl (
    private val getFavoriteListUserCase: GetFavoriteListUserCase
) : IGetAllFavorites {

    override suspend fun getAllFavorites():LiveData<ArrayList<FavoriteToPresentation>> =
        flow<ArrayList<FavoriteToPresentation>> {
            val listOfDataEntity = getFavoriteListUserCase.getAllFavorites()
            try {
                val list = arrayListOf<FavoriteToPresentation>()

                listOfDataEntity.forEach {
                list.add(FavoriteToPresentation.toDomainEntity(it)  )
                }

                emit( list )

            }catch (e : Exception){
                emit(arrayListOf())
            }
        }.asLiveData(Dispatchers.IO)

}