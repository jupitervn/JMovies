package vn.jupiter.jmovies.di

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import vn.jupiter.jmovies.data.MediaRepo
import vn.jupiter.jmovies.data.api.OMDBService
import vn.jupiter.jmovies.data.db.MediaDBService

@Module(includes = [NetworkModule::class])
class RepoModule {
    @Provides
    fun providesMediaRepo(omdbService: OMDBService, dbService: MediaDBService): MediaRepo {
        return MediaRepo(omdbService, dbService, Schedulers.io())
    }
}
