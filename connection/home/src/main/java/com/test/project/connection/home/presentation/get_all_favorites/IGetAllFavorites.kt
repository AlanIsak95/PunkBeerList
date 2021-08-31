package com.test.project.connection.home.presentation.get_all_favorites

import com.test.project.connectionTools.database.entities.Favorite

interface IGetAllFavorites {

    /** */
    suspend fun getAllFavorites():List<Favorite>

}