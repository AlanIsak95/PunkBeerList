package com.test.project.connectionTools.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
data class Person(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id") val userID : Int = 0,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "password") val passWord : String,
    @ColumnInfo(name = "is_login") val isLogin : Int
)
