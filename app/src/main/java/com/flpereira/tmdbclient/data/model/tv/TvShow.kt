package com.flpereira.tmdbclient.data.model.tv


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tvShows")
data class TvShow(
    @ColumnInfo(name = "tvshow_name")
    val name: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @PrimaryKey
    val id: Int,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String
)