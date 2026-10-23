package com.example.catalogandroarch.domain

import com.example.catalogandroarch.data.Products
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Munif
 * @since 19/10/26.
 */
interface ProductApiService {
    @GET("products")
    fun getProducts(@Query("limit") limit: Int): Single<Products>
}