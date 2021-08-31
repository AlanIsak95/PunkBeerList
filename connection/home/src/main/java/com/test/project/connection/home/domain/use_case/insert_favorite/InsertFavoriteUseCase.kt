package com.test.project.connection.home.domain.use_case.insert_favorite

import com.test.project.connection.home.domain.IHomeRepository
import com.test.project.connectionTools.database.entities.Favorite

class InsertFavoriteUseCase(
    private val repository: IHomeRepository
) {
    suspend fun insertFavorite(favorite: Favorite) = repository.insertFavorite(favorite = favorite )
}

