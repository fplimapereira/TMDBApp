package com.flpereira.tmdbclient.data.repository.movies.datasource

import com.flpereira.tmdbclient.data.model.movies.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}