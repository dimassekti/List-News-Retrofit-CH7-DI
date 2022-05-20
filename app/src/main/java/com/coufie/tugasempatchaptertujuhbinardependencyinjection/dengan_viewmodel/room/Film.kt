package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Film(
    @PrimaryKey()
    val id : Int?,
    @ColumnInfo(name = "director")
    var director: String,
    @ColumnInfo(name = "image")
    var image: String,
    @ColumnInfo(name = "date")
    var releaseDate: String,
    @ColumnInfo(name = "description")
    var synopsis: String,
    @ColumnInfo(name = "name")
    var title: String


) : Parcelable
