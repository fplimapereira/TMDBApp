package com.flpereira.tmdbclient.data.repository.tvshows.datasource

import com.flpereira.tmdbclient.data.model.movies.MovieList
import com.flpereira.tmdbclient.data.model.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {

    suspend fun getTvShows(): Response<TvShowList>
}