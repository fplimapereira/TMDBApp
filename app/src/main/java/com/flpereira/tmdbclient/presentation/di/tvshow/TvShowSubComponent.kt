package com.flpereira.tmdbclient.presentation.di.tvshow

import com.flpereira.tmdbclient.presentation.artist.ArtistActivity
import com.flpereira.tmdbclient.presentation.movie.MovieActivity
import com.flpereira.tmdbclient.presentation.tvshow.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory{

        fun create(): TvShowSubComponent
    }
}