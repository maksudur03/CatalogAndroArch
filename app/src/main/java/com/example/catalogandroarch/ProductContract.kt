package com.example.catalogandroarch

import com.example.catalogandroarch.data.Product
import com.example.catalogandroarch.data.Products
import com.example.catalogandroarch.presenter.BasePresenter
import com.example.catalogandroarch.view.BaseView

/**
 * @author Munif
 * @since 21/10/26.
 */
interface ProductContract {
    interface ProductView : BaseView{
        fun setProducts(list: List<Product>)
        fun setEmpty()

    }
    interface ProductPresenter: BasePresenter<ProductView> {
        fun getProducts()
    }
}