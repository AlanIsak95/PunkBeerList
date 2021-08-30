package com.test.project.connection.home.extension

import com.test.project.connection.home.data.dataSource.remote.model.BeerResponseItemDTO
import com.test.project.connection.home.domain.entity.get_random_user.BeerResponseItem

/** Return the String encoded in Base64 */
fun List<BeerResponseItemDTO>.toEntity(): List<BeerResponseItem> =
this.map { it.toEntity() }