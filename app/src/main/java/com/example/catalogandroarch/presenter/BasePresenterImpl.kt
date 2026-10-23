package com.example.catalogandroarch.presenter

import com.example.catalogandroarch.view.BaseView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

/**
 * @author Munif
 * @since 21/10/26.
 */
abstract class BasePresenterImpl<V : BaseView>(private var compositeDisposable: CompositeDisposable) :
    BasePresenter<V> {
    protected var view: V? = null
    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
    }

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}