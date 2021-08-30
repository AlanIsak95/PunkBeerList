package com.test.project.di

import com.test.project.connection.home.homeModule
import com.test.project.connectionTools.database.databaseModule
import com.test.project.connectionTools.httpClient.httpClientModule
import org.koin.core.module.Module

/** En esta seccion estan los casos de uso, capa de datos (capas Clean)*/
fun getConnectionModules(): List<Module> = listOf(
    /** Connection modules **/
    homeModule
)

/** */
fun getConnectionToolsModules(): List<Module> = listOf(
    /** Connection Tools Modules*/
    httpClientModule,
    databaseModule

)
