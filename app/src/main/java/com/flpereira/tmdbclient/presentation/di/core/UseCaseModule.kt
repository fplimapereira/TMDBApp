package com.flpereira.tmdbclient.presentation.di.core

import com.flpereira.tmdbclient.domain.repository.ArtistRepository
import com.flpereira.tmdbclient.domain.repository.MovieRepository
import com.flpereira.tmdbclient.domain.repository.TvShowRepository
import com.flpereira.tmdbclient.domain.usecase.artistuc.GetArtistsUseCase
import com.flpereira.tmdbclient.domain.usecase.artistuc.UpdateArtistsUseCase
import com.flpereira.tmdbclient.domain.usecase.movieuc.GetMoviesUseCase
import com.flpereira.tmdbclient.domain.usecase.movieuc.UpdateMoviesUseCase
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.GetTvShowsUseCase
import com.flpereira.tmdbclient.domain.usecase.tvshowuc.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}