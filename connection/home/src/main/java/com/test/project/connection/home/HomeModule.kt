package com.test.project.connection.home

import com.test.project.connection.home.data.HomeRepositoryImpl
import com.test.project.connection.home.data.dataSource.IHomeLocalDataSource
import com.test.project.connection.home.data.dataSource.IHomeRemoteDataSource
import com.test.project.connection.home.data.dataSource.local.HomeLocalDataSourceImpl
import com.test.project.connection.home.data.dataSource.remote.HomeRemoteDataSourceImpl
import com.test.project.connection.home.data.dataSource.remote.service.HomeApiService
import com.test.project.connection.home.domain.IHomeRepository
import com.test.project.connection.home.domain.use_case.get_beer_list.GetBeerListUserUseCase
import com.test.project.connection.home.domain.use_case.insert_favorite.InsertFavoriteUseCase
import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCase
import com.test.project.connection.home.domain.use_case.login.LoginUseCase
import com.test.project.connection.home.presentation.get_beer_list.GetBeerListImpl
import com.test.project.connection.home.presentation.get_beer_list.IGetBeerList
import com.test.project.connection.home.presentation.insert_favorite.GetInsertFavoriteImpl
import com.test.project.connection.home.presentation.insert_favorite.IGetInsertFavorite
import com.test.project.connection.home.presentation.insert_user.IGetInsertUser
import com.test.project.connection.home.presentation.insert_user.GetIGetInsertUserImpl
import com.test.project.connection.home.presentation.login.GetLoginImpl
import com.test.project.connection.home.presentation.login.IGetLogin
import org.koin.dsl.module
import retrofit2.Retrofit

/* */
val homeModule = module {

    /** PRESENTATION */
    single <IGetBeerList>{ GetBeerListImpl(getBeerListUserUseCase = get()) }
    single <IGetInsertUser>{ GetIGetInsertUserImpl(insertUserUseCase = get()) }
    single <IGetLogin>{ GetLoginImpl(loginUseCase = get()) }
    single <IGetInsertFavorite>{ GetInsertFavoriteImpl(insertFavoriteUseCase = get()) }


    /* USE CASE*/
    factory { GetBeerListUserUseCase(repository = get() ) }
    factory { InsertUserUseCase( repository = get() ) }
    factory { LoginUseCase( repository = get() ) }
    factory { InsertFavoriteUseCase( repository = get() ) }

    /** REPOSITORY */
    single<IHomeRepository> {
        HomeRepositoryImpl(
            remoteDataSource = get(),
            localDataSource = get()
        )
    }

    /** REMOTE DATA SOURCE */
    single<IHomeRemoteDataSource> {
        HomeRemoteDataSourceImpl(
            apiService = get()
        )
    }

    /** LOCAL DATA SOURCE */
    /*Expuesta en ConnectionTools -> Database*/
    single<IHomeLocalDataSource> {
        HomeLocalDataSourceImpl(
            db = get ()
        )
    }

    /** API SERVICE */
    single { get<Retrofit>().create(HomeApiService::class.java) }

}