package com.example.catalogandroarch.view

/**
 * @author Munif
 * @since 21/10/26.
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(msg: String)
}