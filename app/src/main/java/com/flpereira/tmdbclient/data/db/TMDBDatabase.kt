package com.flpereira.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flpereira.tmdbclient.data.db.ArtistsDao
import com.flpereira.tmdbclient.data.db.MoviesDao
import com.flpereira.tmdbclient.data.db.TvShowsDao
import com.flpereira.tmdbclient.data.model.artists.Artist
import com.flpereira.tmdbclient.data.model.movies.Movie
import com.flpereira.tmdbclient.data.model.tv.TvShow

@Database(entities = [Movie::class , TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract  fun movieDao(): MoviesDao
    abstract  fun tvShowDao(): TvShowsDao
    abstract fun artistDao(): ArtistsDao
}