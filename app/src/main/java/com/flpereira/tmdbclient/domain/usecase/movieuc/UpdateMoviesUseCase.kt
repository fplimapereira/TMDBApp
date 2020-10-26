package com.flpereira.tmdbclient.domain.usecase.movieuc

import com.flpereira.tmdbclient.data.model.movies.Movie
import com.flpereira.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository){

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}