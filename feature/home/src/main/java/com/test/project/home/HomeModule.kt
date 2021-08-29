package com.test.project.home

import com.test.project.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/* */
val homeModule = module {

    /* */
    viewModel {
        HomeViewModel(
            getRandomUser = get()
        )
    }

}