package com.test.project.connection.home.domain.entity.get_random_user

data class Location(
    val city: String,
    val coordinates: Coordinates?,
    val country: String,
    val postcode: String,
    val state: String,
    val street: Street?,
    val timezone: Timezone?
)