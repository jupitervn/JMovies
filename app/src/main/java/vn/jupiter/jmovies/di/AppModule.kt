package vn.jupiter.jmovies.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [RepoModule::class])
class AppModule {
    companion object {
        const val BASE_URL_CONFIG = "base_url"
    }

    @Provides
    @Named(BASE_URL_CONFIG)
    fun providesBaseURL(): String = "http://www.omdbapi.com/"
}
