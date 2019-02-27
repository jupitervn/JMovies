package vn.jupiter.jmovies.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import vn.jupiter.jmovies.data.api.OMDBService
import javax.inject.Named


@Module
class NetworkModule {
    @Provides
    fun providesOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request()
                val url = request.url()
                val authUrl = url.newBuilder().addQueryParameter("apiKey", "a1e1e5ed").build()
                chain.proceed(request.newBuilder().url(authUrl).build())
            }
            .build()
    }

    @Provides
    fun providesRetrofit(
        @Named(AppModule.BASE_URL_CONFIG)
        baseUrl: String,
        client: OkHttpClient,
        moshi: Moshi
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideOMDBService(retrofit: Retrofit) = retrofit.create(OMDBService::class.java)
}
