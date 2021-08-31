package com.test.project.connectionTools.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favoritos")
data class Favorite(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "favorite_id") val id : Int = 0,
    @ColumnInfo(name = "beer_name") val name : String,
    @ColumnInfo(name = "contributed_by") val contributedBy : String,
    @ColumnInfo(name = "rate_value") val rateValue : Double,
    @ColumnInfo(name = "image_url") val imageURL : String
)
