package com.flpereira.tmdbclient.data.repository.movies.datasourceimpl

import com.flpereira.tmdbclient.data.db.MoviesDao
import com.flpereira.tmdbclient.data.model.movies.Movie
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val moviesDao: MoviesDao):
    MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> = moviesDao.getAllMovies()


    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.deleteAllMovies()
        }
    }
}