package com.test.project.connection.home.data.dataSource.local.models

import com.test.project.connectionTools.database.entities.Favorite


data class FavoriteToPresentation(
    val id : Int = 0,
    val name : String,
    val contributedBy : String,
    val rateValue : Double,
    val imageURL : String
){

    /** For Send the info to Layer Presentation */
    companion object {
        fun toDomainEntity(
            dbEntity: Favorite
        ): FavoriteToPresentation =
            FavoriteToPresentation(
                id = dbEntity.id,
                name = dbEntity.name,
                contributedBy = dbEntity.contributedBy,
                rateValue = dbEntity.rateValue,
                imageURL = dbEntity.imageURL
            )
    }

}
