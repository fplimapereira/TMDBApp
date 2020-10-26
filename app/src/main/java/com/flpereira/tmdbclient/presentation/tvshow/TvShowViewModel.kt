package com.flpereira.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.flpereira.tmdbclient.data.model.tv.TvShow
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.GetTvShowsUseCase
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowsList: List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows() = liveData {
        val tvShowsList: List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}