package com.flpereira.tmdbclient.data.model.movies


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movies")
data class Movie(
    @SerializedName("poster_path")
    val posterPath: String,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title_name")
    val title: String,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String
)