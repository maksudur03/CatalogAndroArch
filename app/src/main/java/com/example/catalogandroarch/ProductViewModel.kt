package com.example.catalogandroarch

import androidx.lifecycle.ViewModel
import com.example.catalogandroarch.ProductUiState.Loading
import com.example.catalogandroarch.data.Products
import com.example.catalogandroarch.domain.ApiCallBack
import com.example.catalogandroarch.domain.ApiParse
import com.example.catalogandroarch.domain.ProductApiRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * @author Munif
 * @since 24/10/26.
 */
class ProductViewModel @Inject constructor(private val apiRepository: ProductApiRepository): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _uiState: MutableStateFlow<ProductUiState> = MutableStateFlow<ProductUiState>(Loading)
    val uiState : StateFlow<ProductUiState> = _uiState.asStateFlow()

    init {
        getProducts()
    }
    fun getProducts() {
        _uiState.value = Loading
        compositeDisposable.add(apiRepository.getProducts(10, object : ApiCallBack<Products> {
            override fun onSuccess(response: Products) {
                if (response.data == null) {
                    _uiState.value = ProductUiState.Error("No Product found")
                    return
                }
                _uiState.value = ProductUiState.Success(response.data)
            }

            override fun onError(error: ApiParse.ApiError) {
                _uiState.value = ProductUiState.Error(error.msg)
            }
        }))
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }
}