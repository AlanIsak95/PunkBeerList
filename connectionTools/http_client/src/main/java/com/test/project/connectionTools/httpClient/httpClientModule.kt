package com.test.project.connectionTools.httpClient

import com.test.project.connectionTools.httpClient.retrofit.RetrofitBuilderObject
import org.koin.dsl.module

/* */
val httpClientModule = module {
    /* */
    single {
        RetrofitBuilderObject(
            baseUrl = "https://api.punkapi.com/v2/"
        ).build()
    }
}