package com.test.project.di

import com.test.project.home.homeModule
import org.koin.core.module.Module

/** */
fun getFeatureModules(): List<Module> = listOf(
    /** Home */
    homeModule
)

/** */
fun getFeatureToolsModules(): List<Module> = listOf(
    /** Features Tools */

)

