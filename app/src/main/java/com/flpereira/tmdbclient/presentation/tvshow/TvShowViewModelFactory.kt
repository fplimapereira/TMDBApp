package com.flpereira.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flpereira.tmdbclient.domain.usecase.movieuc.GetMoviesUseCase
import com.flpereira.tmdbclient.domain.usecase.movieuc.UpdateMoviesUseCase
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.GetTvShowsUseCase
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}