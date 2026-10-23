package com.example.catalogandroarch.presenter

import com.example.catalogandroarch.ProductContract.ProductPresenter
import com.example.catalogandroarch.ProductContract.ProductView
import com.example.catalogandroarch.data.Products
import com.example.catalogandroarch.domain.ApiCallBack
import com.example.catalogandroarch.domain.ApiParse
import com.example.catalogandroarch.domain.ProductApiRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * @author Munif
 * @since 21/10/26.
 */
class ProductPresenterImpl(
    private val compositeDisposable: CompositeDisposable,
    private val productApiRepository: ProductApiRepository
) :
    BasePresenterImpl<ProductView>(compositeDisposable), ProductPresenter {
    override fun getProducts() {
        view?.showLoading()
        compositeDisposable.add(productApiRepository.getProducts(20, object : ApiCallBack<Products> {
            override fun onSuccess(response: Products) {
                view?.hideLoading()
                response.data?.let { list ->
                    view?.setProducts(list)
                } ?: {
                    view?.setEmpty()
                }
            }

            override fun onError(error: ApiParse.ApiError) {
                view?.run {
                    hideLoading()
                    setEmpty()
                }
            }
        }))
    }
}