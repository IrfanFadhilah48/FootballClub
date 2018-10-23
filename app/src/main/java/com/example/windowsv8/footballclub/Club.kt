package com.example.windowsv8.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(val nama : String?, val image: Int?, val keterangan: String?) : Parcelable
//tester123