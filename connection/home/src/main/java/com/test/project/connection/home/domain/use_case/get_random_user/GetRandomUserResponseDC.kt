package com.test.project.connection.home.domain.use_case.get_random_user

import com.test.project.connection.home.domain.entity.get_random_user.GetRandomUserResponse

data class GetRandomUserResponseDC(
    val user: GetRandomUserResponse? = null,
    val failure : String? = null
    )
