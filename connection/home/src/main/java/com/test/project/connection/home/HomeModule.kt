package com.test.project.connection.home

import com.test.project.connection.home.data.HomeRepositoryImpl
import com.test.project.connection.home.data.dataSource.IHomeRemoteDataSource
import com.test.project.connection.home.data.dataSource.remote.HomeRemoteDataSourceImpl
import com.test.project.connection.home.data.dataSource.remote.service.HomeApiService
import com.test.project.connection.home.domain.IHomeRepository
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserUseCase
import com.test.project.connection.home.presentation.GetRandomUserImpl
import com.test.project.connection.home.presentation.IGetRandomUser
import org.koin.dsl.module
import retrofit2.Retrofit

/* */
val homeModule = module {

    /** PRESENTATION */
    single <IGetRandomUser>{
        GetRandomUserImpl(
            getRandomUserUseCase = get()
        )
    }

    /* USE CASE*/
    factory { GetRandomUserUseCase(
        repository = get()
    ) }

    /** REPOSITORY */
    single<IHomeRepository> {
        HomeRepositoryImpl(
            remoteDataSource = get()
        )
    }

    /** REMOTE DATA SOURCE */
    single<IHomeRemoteDataSource> {
        HomeRemoteDataSourceImpl(
            apiService = get()
        )
    }

    /** API SERVICE */
    single { get<Retrofit>().create(HomeApiService::class.java) }

}