package com.example.catalogandroarch.domain

import com.example.catalogandroarch.data.Products
import com.example.catalogandroarch.domain.ApiParse.subscribeForApp
import io.reactivex.rxjava3.disposables.Disposable

/**
 * @author Munif
 * @since 19/10/26.
 */
class ProductApiRepositoryImpl(private val apiService: ProductApiService) : ProductApiRepository {

    override fun getProducts(limit: Int, callBack: ApiCallBack<Products>): Disposable {
        return apiService.getProducts(limit).subscribeForApp(callBack)
    }
}