package com.grtapplications.android.nasaapod.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.grtapplications.android.nasaapod.data.DailyImage
import com.grtapplications.android.nasaapod.data.DailyImageRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val dailyImageRepository: DailyImageRepository = DailyImageRepository()

    val dailyImages: LiveData <List<DailyImage>> = liveData {
        val data = dailyImageRepository.getDailyImages()
        emit(data)
    }
}