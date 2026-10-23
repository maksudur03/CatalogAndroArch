package com.example.catalogandroarch.di.component

import com.example.catalogandroarch.ProductContract.ProductPresenter
import com.example.catalogandroarch.di.module.ProductModule
import com.example.catalogandroarch.di.scope.ActivityScope
import dagger.Component

/**
 * @author Munif
 * @since 22/10/26.
 */

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ProductModule::class])
interface ProductComponent {
    val productPresenter: ProductPresenter
}