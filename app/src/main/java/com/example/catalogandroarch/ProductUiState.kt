package com.example.catalogandroarch

import com.example.catalogandroarch.data.Product

/**
 * @author Munif
 * @since 24/10/26.
 */
sealed interface ProductUiState {
    data object Loading : ProductUiState
    data class Success(val products: List<Product>) : ProductUiState
    data class Error(val msg: String): ProductUiState
}