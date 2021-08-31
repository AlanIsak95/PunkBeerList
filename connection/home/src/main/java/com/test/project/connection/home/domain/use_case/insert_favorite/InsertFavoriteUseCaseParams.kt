package com.test.project.connection.home.domain.use_case.insert_favorite

import com.test.project.connectionTools.database.entities.Favorite

data class InsertFavoriteUseCaseParams(
    val id : Int,
    val name : String,
    val contributedBy : String,
    val rateValue : Double,
    val imageUrl : String

){
    fun toFavoriteEntity(): Favorite =
        Favorite(
            id = id,
            name = name,
            contributedBy = contributedBy,
            rateValue = rateValue,
            imageURL = imageUrl
        )
}
