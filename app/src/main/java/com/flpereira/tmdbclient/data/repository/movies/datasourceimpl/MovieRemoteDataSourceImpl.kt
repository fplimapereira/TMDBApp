package com.flpereira.tmdbclient.data.repository.movies.datasourceimpl

import com.flpereira.tmdbclient.data.api.TMDBService
import com.flpereira.tmdbclient.data.model.movies.MovieList
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String):
    MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}