package com.test.project.connection.home.presentation.get_all_favorites

import com.test.project.connection.home.domain.use_case.get_all_favorites.GetFavoriteListUserCase
import com.test.project.connectionTools.database.entities.Favorite


class GetAllFavoritesImpl (
    private val getFavoriteListUserCase: GetFavoriteListUserCase
) : IGetAllFavorites {

    override suspend fun getAllFavorites(): List<Favorite> =
        getFavoriteListUserCase.getAllFavorites()



}