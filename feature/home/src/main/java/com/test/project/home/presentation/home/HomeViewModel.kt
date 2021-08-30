package com.test.project.home.presentation.home

import androidx.lifecycle.ViewModel
import com.test.project.connection.home.presentation.get_random_user.IGetRandomUser
import com.test.project.connection.home.presentation.insert_user.IGetInsertUser

class HomeViewModel(
    getRandomUser : IGetRandomUser,
    IGetInsertUser : IGetInsertUser
) : ViewModel(),
    IGetRandomUser by getRandomUser,
    IGetInsertUser by IGetInsertUser