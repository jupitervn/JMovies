package vn.jupiter.jmovies.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import vn.jupiter.jmovies.data.model.MovieInfo

interface OMDBService {
    @GET("/")
    fun search(
        @Query("s") keyword: String,
        @Query("page") page: Int = 0
    ): Single<SearchResponse>

    @GET("/")
    fun getByID(
        @Query("t") imdbID: String,
        @Query("plot") isFullPlot: Boolean
    ): Single<MovieInfo>
}
