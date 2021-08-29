package com.test.project.home.presentation

import androidx.lifecycle.ViewModel
import com.test.project.connection.home.presentation.IGetRandomUser

class HomeViewModel(
    getRandomUser : IGetRandomUser
) : ViewModel(), IGetRandomUser by getRandomUser