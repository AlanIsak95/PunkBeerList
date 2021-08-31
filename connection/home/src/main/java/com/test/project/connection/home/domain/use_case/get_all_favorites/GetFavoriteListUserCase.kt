package com.test.project.connection.home.domain.use_case.get_all_favorites

import com.test.project.connection.home.domain.IHomeRepository

class GetFavoriteListUserCase (
    private val repository: IHomeRepository
) {
    suspend fun getAllFavorites() = repository.getAllFavorites()
}
