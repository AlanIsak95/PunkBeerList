package com.test.project.connection.home.presentation.insert_favorite

import com.test.project.connection.home.domain.use_case.insert_favorite.InsertFavoriteUseCaseParams

interface IGetInsertFavorite {

    suspend fun insertFavorite(favorite: InsertFavoriteUseCaseParams)

}