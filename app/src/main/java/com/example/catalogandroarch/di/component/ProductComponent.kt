package com.example.catalogandroarch.di.component

import com.example.catalogandroarch.ProductViewModel
import com.example.catalogandroarch.di.scope.ActivityScope
import dagger.Component

/**
 * @author Munif
 * @since 22/10/26.
 */

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ProductComponent {
    val productViewModel: ProductViewModel
}