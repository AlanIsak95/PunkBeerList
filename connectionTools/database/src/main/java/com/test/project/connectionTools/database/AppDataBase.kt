package com.test.project.connectionTools.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.project.connectionTools.database.dao.PersonDao
import com.test.project.connectionTools.database.entities.Person

/* */
@Database(
    entities = [Person::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    /** */
    companion object {

        /** */
        @Volatile
        private var INSTANCE: AppDataBase? = null

        /** */
        fun getInstance(context: Context): AppDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            /*se protege todo lo que esta dentro del bloque a la ejeciciones por multiples hilos*/
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }

}