package com.test.project.connection.home.extension

import com.test.project.connection.home.data.dataSource.remote.model.BeerResponseItemDTO
import com.test.project.connection.home.domain.entity.get_beer_list.BeerResponseItem

/** Return the List mapped */
fun List<BeerResponseItemDTO>.toEntity(): List<BeerResponseItem> =
this.map { it.toEntity() }