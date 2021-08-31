package com.test.project.home.presentation.favorites

import androidx.lifecycle.ViewModel
import com.test.project.connection.home.presentation.get_all_favorites.IGetAllFavorites

class FavoriteViewModel(
    getAllFavorites : IGetAllFavorites
) : ViewModel(),
     IGetAllFavorites by getAllFavorites