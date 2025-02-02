package com.example.kotlin63.di


import com.example.kotlin63.data.remote.apiservises.AnimeMangaApiServises
import com.example.kotlin63.data.repositories.AnimeMangaRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = " https://kitsu.io/api/edge/"

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object RetrofitClient {

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            ).connectTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS).callTimeout(60L, TimeUnit.SECONDS).build()

        @Provides
        @Singleton
        fun retrofitClient(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build()

        @Provides
        @Singleton
        fun provideAnimeApiServises(retrofit: Retrofit): AnimeMangaApiServises {
            return retrofit.create(AnimeMangaApiServises::class.java)
        }
    }

    @Provides
    @Singleton
    fun provideAnimeRepositories(animeApi: AnimeMangaApiServises) = AnimeMangaRepositories(animeApi)
}