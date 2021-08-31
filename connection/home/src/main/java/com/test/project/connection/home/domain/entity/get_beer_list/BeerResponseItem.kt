package com.test.project.connection.home.domain.entity.get_beer_list

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Keep
@Parcelize
data class BeerResponseItem(
    val abv: Double?,
    val attenuation_level: Double?,
    val boil_volume: @RawValue BoilVolume?,
    val brewers_tips: String?,
    val contributed_by: String?,
    val description: String?,
    val ebc: Double?,
    val first_brewed: String?,
    val food_pairing: List<String>?,
    val ibu: Double?,
    val id: Int?,
    val image_url: String?,
    val ingredients: @RawValue Ingredients?,
    val method:  @RawValue Method?,
    val name: String?,
    val ph: Double?,
    val srm: Double?,
    val tagline: String?,
    val target_fg: Int?,
    val target_og: Double?,
    val volume: @RawValue Volume?
) : Parcelable