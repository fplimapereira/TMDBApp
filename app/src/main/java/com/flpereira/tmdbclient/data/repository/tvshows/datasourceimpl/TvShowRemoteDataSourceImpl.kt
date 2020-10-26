package com.flpereira.tmdbclient.data.repository.tvshows.datasourceimpl

import com.flpereira.tmdbclient.data.api.TMDBService
import com.flpereira.tmdbclient.data.model.movies.MovieList
import com.flpereira.tmdbclient.data.model.tv.TvShowList
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieRemoteDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String):
    TvShowRemoteDatasource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}