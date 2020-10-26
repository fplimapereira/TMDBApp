package com.flpereira.tmdbclient.presentation

import android.app.Application
import com.flpereira.tmdbclient.BuildConfig
import com.flpereira.tmdbclient.presentation.di.Injector
import com.flpereira.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.flpereira.tmdbclient.presentation.di.core.*
import com.flpereira.tmdbclient.presentation.di.movie.MovieSubComponent
import com.flpereira.tmdbclient.presentation.di.tvshow.TvShowSubComponent


@Suppress("DEPRECATION")
class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }


    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}