package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.Location

internal data class LocationDTO(
    val city: String?,
    val coordinates: CoordinatesDTO?,
    val country: String?,
    val postcode: String?,
    val state: String?,
    val street: StreetDTO?,
    val timezone: TimezoneDTO?
){

    /** */
    fun toLocation():Location =
        try {
            Location(
                city = city?:"",
                coordinates = coordinates?.toCoordinates(),
                country = country?:"",
                postcode = postcode?:"",
                state = state?:"",
                street = street?.toStreet(),
                timezone = timezone?.toTimeZone()
            )
        }catch (e:Exception){
            Location(
                city = "",
                coordinates = coordinates?.toCoordinates(),
                country = "",
                postcode = "",
                state = "",
                street = street?.toStreet(),
                timezone = timezone?.toTimeZone()
            )
        }


}