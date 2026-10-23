package com.example.catalogandroarch.di.module

import com.example.catalogandroarch.di.scope.ApplicationScope
import com.example.catalogandroarch.domain.ProductApiRepository
import com.example.catalogandroarch.domain.ProductApiRepositoryImpl
import com.example.catalogandroarch.domain.ProductApiService
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

/**
 * @author Munif
 * @since 21/10/26.
 */

@Module
class NetworkModule {
    @Provides
    @ApplicationScope
    fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).connectTimeout(60, SECONDS)
            .readTimeout(60, SECONDS)
            .writeTimeout(60, SECONDS)
            .build()

    @Provides
    @ApplicationScope
    fun retrofit(client: OkHttpClient): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    @ApplicationScope
    fun productApiService(retrofit: Retrofit): ProductApiService =
        retrofit.create(ProductApiService::class.java)

    @Provides
    @ApplicationScope
    fun productApiRepository(apiService: ProductApiService): ProductApiRepository =
        ProductApiRepositoryImpl(apiService)

}