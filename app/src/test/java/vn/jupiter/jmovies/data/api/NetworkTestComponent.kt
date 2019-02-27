package vn.jupiter.jmovies.data.api

import dagger.Component
import retrofit2.Retrofit
import vn.jupiter.jmovies.di.AppModule
import vn.jupiter.jmovies.di.NetworkModule

@Component(modules = [NetworkModule::class, AppModule::class])
interface NetworkTestComponent {
    fun getRetrofit(): Retrofit
}
