package com.grtapplications.android.nasaapod.data

import com.grtapplications.android.nasaapod.BuildConfig
import retrofit2.http.GET
import retrofit2.Response

interface DailyImageApi {
    /* TODO: Handle start and end dates better.
        We should get the end date from the api (whatever the current daily image is), then
        calculate start date and pass those values into the request.
        @Query("api_key")
        @Query("start_date")
        @Query("end_date")
    */
    @GET("/planetary/apod?api_key=${BuildConfig.API_KEY}&start_date=2021-10-28&end_date=2021-11-03")
    suspend fun getDailyImages(): Response<List<DailyImage>>
}