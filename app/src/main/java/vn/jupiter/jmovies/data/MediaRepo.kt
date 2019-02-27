package vn.jupiter.jmovies.data

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import vn.jupiter.jmovies.data.api.OMDBService
import vn.jupiter.jmovies.data.db.MediaDBService
import vn.jupiter.jmovies.data.model.MovieInfo

class MediaRepo(fetchService: OMDBService, dbService: MediaDBService, executor: Scheduler = Schedulers.io()) {
    fun searchMovies(keyword: String, page: Int): Flowable<MovieInfo> {
        return Flowable.just(MovieInfo("", "", "", "", ""))
    }

    fun getMovieDetailByID(mediaID: String): Maybe<MovieInfo> {
        return Maybe.empty()
    }
}
