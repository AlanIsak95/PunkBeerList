package com.test.project

import android.app.Application
import com.test.project.di.startKoin
import org.koin.core.component.KoinComponent

class RootApplication : Application(), KoinComponent {

    /** */
    override fun onCreate() {
        super.onCreate()
        /*Se cargan todos los archivos "MODULE" dentro de cada <modulo del app> para hacer DI*/
        startKoin()
    }
}