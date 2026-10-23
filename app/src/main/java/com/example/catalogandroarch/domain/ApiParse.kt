package com.example.catalogandroarch.domain

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.serialization.SerializationException
import okio.IOException
import retrofit2.HttpException

/**
 * @author Munif
 * @since 19/10/26.
 */

object ApiParse {
    class ApiError(val code: Int, val msg: String)

    fun parseError(throwable: Throwable): ApiError = when (throwable) {
        is HttpException -> ApiError(throwable.code(), throwable.message())
        is IOException -> ApiError(-1, "No Internet")
        is SerializationException -> ApiError(-2, "Bad response")
        else -> ApiError(-3, "Something wrong")
    }

    fun <T : Any> Single<T>.subscribeForApp(callBack: ApiCallBack<T>): Disposable =
        subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ callBack.onSuccess(it) }, { callBack.onError(parseError(it)) })
}