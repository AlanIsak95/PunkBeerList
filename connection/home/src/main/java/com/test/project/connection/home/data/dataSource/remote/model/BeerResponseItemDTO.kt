package com.test.project.connection.home.data.dataSource.remote.model

import com.test.project.connection.home.domain.entity.get_random_user.BeerResponseItem

data class BeerResponseItemDTO(
    val abv: Double?,
    val attenuation_level: Double?,
    val boil_volume: BoilVolumeDTO?,
    val brewers_tips: String?,
    val contributed_by: String?,
    val description: String?,
    val ebc: Double?,
    val first_brewed: String?,
    val food_pairing: List<String>?,
    val ibu: Double?,
    val id: Int?,
    val image_url: String?,
    val ingredients: IngredientsDTO?,
    val method: MethodDTO?,
    val name: String?,
    val ph: Double?,
    val srm: Double?,
    val tagline: String?,
    val target_fg: Int?,
    val target_og: Double?,
    val volume: VolumeDTO?
){
    fun toEntity(): BeerResponseItem =
        BeerResponseItem(
            abv = abv,
            attenuation_level = attenuation_level,
            boil_volume = boil_volume?.toEntity(),
            brewers_tips = brewers_tips,
            contributed_by = contributed_by,
            description = description,
            ebc = ebc,
            first_brewed = first_brewed,
            food_pairing = food_pairing,
            ibu = ibu,
            id = id,
            image_url = image_url,
            ingredients = ingredients?.toEntity(),
            method = method?.toEntity(),
            name = name,
            ph = ph,
            srm = srm,
            tagline = tagline,
            target_fg = target_fg,
            target_og = target_og,
            volume = volume?.toEntity()
        )
}