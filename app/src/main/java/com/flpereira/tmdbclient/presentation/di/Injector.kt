package com.flpereira.tmdbclient.presentation.di

import com.flpereira.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.flpereira.tmdbclient.presentation.di.movie.MovieSubComponent
import com.flpereira.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent

    fun createTvShowSubComponent(): TvShowSubComponent

    fun createArtistSubComponent(): ArtistSubComponent
}