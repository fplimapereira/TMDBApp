package com.flpereira.tmdbclient.data.repository.movies

import android.util.Log
import com.flpereira.tmdbclient.data.model.movies.Movie
import com.flpereira.tmdbclient.data.model.movies.MovieList
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieCacheDatasource
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieLocalDatasource
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieRemoteDatasource
import com.flpereira.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
       val newListOfMovies: List<Movie> = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var moviesList:List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDatasource.getMovies()
            val body: MovieList? = response.body()
            if (body!=null){
                moviesList = body.movies
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return moviesList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var moviesList:List<Movie>
        try {
           moviesList = movieLocalDatasource.getMoviesFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (moviesList.isNotEmpty()){
            return moviesList
        }else{
            moviesList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(moviesList)
        }
        return moviesList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var moviesList:List<Movie>
        try {
            moviesList = movieCacheDatasource.getMoviesFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (moviesList.isNotEmpty()){
            return moviesList
        }else{
            moviesList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(moviesList)
        }
        return moviesList
    }
}