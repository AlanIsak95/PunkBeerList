package com.test.project.connectionTools.httpClient.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilderObject(private val baseUrl: String) {

    /* */
    private val timeOut: Long = 100L

    /** */
    fun build(): Retrofit =
        Retrofit.Builder()
            .client(buildHttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    /** */
    private fun buildHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .build()



}
