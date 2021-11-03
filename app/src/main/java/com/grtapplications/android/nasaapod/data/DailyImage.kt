package com.grtapplications.android.nasaapod.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DailyImage (
    val copyright: String?=null,
    val date: String?=null,
    val explanation: String?=null,
    val hdurl: String?=null,
    val media_type: String?=null,
    val service_version: String?=null,
    val title: String?=null,
    val url: String?=null,
): Parcelable

