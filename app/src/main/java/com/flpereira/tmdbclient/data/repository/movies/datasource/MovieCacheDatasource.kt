package com.flpereira.tmdbclient.data.repository.movies.datasource

import com.flpereira.tmdbclient.data.model.movies.Movie

interface MovieCacheDatasource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}