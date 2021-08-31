package com.test.project.connection.home.presentation.insert_favorite

import com.test.project.connection.home.domain.use_case.insert_favorite.InsertFavoriteUseCase
import com.test.project.connection.home.domain.use_case.insert_favorite.InsertFavoriteUseCaseParams


class GetInsertFavoriteImpl  (
    private val insertFavoriteUseCase: InsertFavoriteUseCase
) : IGetInsertFavorite {

    override suspend fun insertFavorite(favorite: InsertFavoriteUseCaseParams) =
        insertFavoriteUseCase.insertFavorite(favorite = favorite.toFavoriteEntity())

}