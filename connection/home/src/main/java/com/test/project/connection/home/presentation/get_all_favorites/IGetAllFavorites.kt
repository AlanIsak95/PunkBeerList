package com.test.project.connection.home.presentation.get_all_favorites

import androidx.lifecycle.LiveData
import com.test.project.connection.home.data.dataSource.local.models.FavoriteToPresentation

interface IGetAllFavorites {

    /** */
    suspend fun getAllFavorites():LiveData<ArrayList<FavoriteToPresentation>>

}