package com.example.catalogandroarch.di.module

import com.example.catalogandroarch.ProductContract
import com.example.catalogandroarch.di.scope.ActivityScope
import com.example.catalogandroarch.domain.ProductApiRepository
import com.example.catalogandroarch.presenter.ProductPresenterImpl
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * @author Munif
 * @since 21/10/26.
 */
@Module(includes = [ActivityModule::class])
class ProductModule {
    @Provides
    @ActivityScope
    fun productPresenter(compositeDisposable: CompositeDisposable, productApiRepository: ProductApiRepository): ProductContract.ProductPresenter =
        ProductPresenterImpl(compositeDisposable, productApiRepository)
}