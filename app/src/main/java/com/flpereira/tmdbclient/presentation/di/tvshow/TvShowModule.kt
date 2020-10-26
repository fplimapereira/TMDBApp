package com.flpereira.tmdbclient.presentation.di.tvshow


import com.flpereira.tmdbclient.domain.usecase.movieuc.GetMoviesUseCase
import com.flpereira.tmdbclient.domain.usecase.movieuc.UpdateMoviesUseCase
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.GetTvShowsUseCase
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.UpdateTvShowsUseCase
import com.flpereira.tmdbclient.presentation.movie.MovieViewModelFactory
import com.flpereira.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowsUseCase: GetTvShowsUseCase,
    updateTvShowsUseCase: UpdateTvShowsUseCase): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}