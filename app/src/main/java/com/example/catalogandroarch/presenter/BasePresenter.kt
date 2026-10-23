package com.example.catalogandroarch.presenter

import com.example.catalogandroarch.view.BaseView

/**
 * @author Munif
 * @since 21/10/26.
 */
interface BasePresenter<V: BaseView> {
    fun onAttach(view: V)
    fun onDetach()
}