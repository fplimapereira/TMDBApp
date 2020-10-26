package com.flpereira.tmdbclient.domain.repository

import com.flpereira.tmdbclient.data.model.movies.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}