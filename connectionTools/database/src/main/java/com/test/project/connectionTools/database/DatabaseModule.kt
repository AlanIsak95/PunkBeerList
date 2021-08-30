package com.test.project.connectionTools.database

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single { AppDataBase.getInstance(context = androidApplication()) }

}