package com.flpereira.tmdbclient.domain.usecase.tvshowuc

import com.flpereira.tmdbclient.data.model.tv.TvShow
import com.flpereira.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}