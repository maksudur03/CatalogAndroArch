package com.example.catalogandroarch.di.module

import com.example.catalogandroarch.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * @author Munif
 * @since 22/10/26.
 */

@Module
class ActivityModule {
    @Provides
    @ActivityScope
    fun compositeDisposable(): CompositeDisposable = CompositeDisposable()
}