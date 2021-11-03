package com.grtapplications.android.nasaapod.data

import com.grtapplications.android.nasaapod.BASE_ENDPOINT_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Encapsulates where the app gets data and publishes that data to subscribers
 */
class DailyImageRepository {

    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val dailyImageApi: DailyImageApi by lazy {
        retrofit.create(DailyImageApi::class.java)
    }

    suspend fun getDailyImages(): List<DailyImage> {
        val response = dailyImageApi.getDailyImages()
        return if (response.isSuccessful)
            response.body() ?: emptyList()
        else
            emptyList()
    }
}