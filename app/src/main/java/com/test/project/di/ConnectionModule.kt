package com.test.project.di

import com.test.project.connection.home.homeModule
import com.test.project.connectionTools.httpClient.httpClientModule
import org.koin.core.module.Module

/** */
fun getConnectionModules(): List<Module> = listOf(
    /** Connection modules **/
    homeModule
)

/** */
fun getConnectionToolsModules(): List<Module> = listOf(
    /** Connection Tools Modules*/
    httpClientModule

)
