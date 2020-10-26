package com.flpereira.tmdbclient.data.repository.movies.datasource

import com.flpereira.tmdbclient.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies(): Response<MovieList>
}