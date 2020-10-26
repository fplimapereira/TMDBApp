package com.flpereira.tmdbclient.data.repository.movies.datasourceimpl

import com.flpereira.tmdbclient.data.model.movies.Movie
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieCacheDatasource

class MovieCacheDataSourceImpl:
    MovieCacheDatasource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> = movieList


    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

}