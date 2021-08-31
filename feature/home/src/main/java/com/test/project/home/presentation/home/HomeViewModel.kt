package com.test.project.home.presentation.home

import androidx.lifecycle.ViewModel
import com.test.project.connection.home.presentation.get_beer_list.IGetBeerList
import com.test.project.connection.home.presentation.insert_favorite.IGetInsertFavorite
import com.test.project.connection.home.presentation.insert_user.IGetInsertUser

class HomeViewModel(
    getBeerList : IGetBeerList,
    iGetInsertUser : IGetInsertUser,
    iGetInsertFavorite: IGetInsertFavorite
) : ViewModel(),
    IGetBeerList by getBeerList,
    IGetInsertUser by iGetInsertUser,
    IGetInsertFavorite by iGetInsertFavorite