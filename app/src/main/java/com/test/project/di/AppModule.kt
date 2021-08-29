package com.test.project.di

import com.test.project.RootApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/** */
fun RootApplication.startKoin(){

    startKoin{
        val featureModules = getFeatureModules() + getFeatureToolsModules()
        val connectionModules = getConnectionModules() + getConnectionToolsModules()
        val allModules = featureModules + connectionModules
        androidLogger(Level.ERROR)
        androidContext(this@startKoin)
        modules(allModules)
    }

}