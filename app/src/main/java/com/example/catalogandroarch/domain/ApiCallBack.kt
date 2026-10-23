package com.example.catalogandroarch.domain

/**
 * @author Munif
 * @since 19/10/26.
 */
interface ApiCallBack<T> {
    fun onSuccess(response: T)
    fun onError(error: ApiParse.ApiError)
}