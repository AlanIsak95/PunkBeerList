package com.test.project.home

import com.test.project.home.presentation.home.HomeViewModel
import com.test.project.home.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/* */
val homeModule = module {

    /* */
    viewModel {
        HomeViewModel(
            getBeerList = get(),
            iGetInsertUser = get(),
            iGetInsertFavorite = get()
        )
    }

    /* */
    viewModel {LoginViewModel(iGetLogin = get(),get())  }

}