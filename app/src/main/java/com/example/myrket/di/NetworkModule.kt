package com.example.myrket.di

import android.content.Context
import com.example.myrket.App
import com.example.myrket.BuildConfig
import com.example.myrket.data.api.TmdbApi
import com.example.myrket.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@Suppress("unused")
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): App = app as App

    @Singleton
    @Provides
    fun provideAuthInterceptor(): Interceptor = Interceptor { chain ->
        val newUrl = chain
            .request().url
            .newBuilder()
            .addQueryParameter("tmdb_api_key", BuildConfig.TMDB_API_KEY).build()

        val newRequest = chain
            .request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideHttpCache(context: Context): Cache {
        val httpCacheDirectory = File(context.cacheDir.absolutePath, CACHE_DIRECTORY_TAG)
        return Cache(httpCacheDirectory, CACHE_SIZE_BYTES)

    }

    @Singleton
    @Provides
    fun provideTmdbClient(
        authInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .cache(cache)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideTmdbApi(retrofit: Retrofit): TmdbApi = retrofit.create(TmdbApi::class.java)
}

private const val READ_TIMEOUT: Long = 30
private const val WRITE_TIMEOUT: Long = 30
private const val CONNECTION_TIMEOUT: Long = 10
private const val CACHE_SIZE_BYTES: Long = 10 * 1024 * 1024L // 10 MB
private const val CACHE_DIRECTORY_TAG = "HttpCache"