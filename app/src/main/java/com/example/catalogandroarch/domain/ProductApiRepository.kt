package com.example.catalogandroarch.domain

import com.example.catalogandroarch.data.Products
import io.reactivex.rxjava3.disposables.Disposable

/**
 * @author Munif
 * @since 19/10/26.
 */
interface ProductApiRepository {
    fun getProducts(limit: Int, callBack: ApiCallBack<Products>) : Disposable
}