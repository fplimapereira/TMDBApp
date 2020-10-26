package com.flpereira.tmdbclient.domain.repository

import com.flpereira.tmdbclient.data.model.tv.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}