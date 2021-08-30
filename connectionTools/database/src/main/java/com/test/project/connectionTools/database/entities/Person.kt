package com.test.project.connectionTools.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_tbl")
data class Person(
    @PrimaryKey
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "password") val passWord : String,
    @ColumnInfo(name = "is_login") val isLogin : Int
)
