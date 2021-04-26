package com.picpay.desafio.android.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class User(
    @SerializedName ("img") val img: String,
    @SerializedName ("name") val name: String,
    @SerializedName ("id") val id: Int,
    @SerializedName ("username") val username: String
) : Parcelable
