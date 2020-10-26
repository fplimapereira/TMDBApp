package com.flpereira.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.flpereira.tmdbclient.data.model.movies.Movie
import com.flpereira.tmdbclient.domain.usecase.movieuc.GetMoviesUseCase
import com.flpereira.tmdbclient.domain.usecase.movieuc.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList: List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }
}