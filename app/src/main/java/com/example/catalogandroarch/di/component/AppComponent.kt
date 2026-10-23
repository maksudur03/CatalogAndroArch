package com.example.catalogandroarch.di.component

import com.example.catalogandroarch.di.module.NetworkModule
import com.example.catalogandroarch.di.scope.ApplicationScope
import com.example.catalogandroarch.domain.ProductApiRepository
import dagger.Component

/**
 * @author Munif
 * @since 19/10/26.
 */
@ApplicationScope
@Component(modules = [NetworkModule::class])
interface AppComponent {
    val productApiRepository: ProductApiRepository
}