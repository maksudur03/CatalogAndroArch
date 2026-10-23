package com.example.catalogandroarch

import android.app.Application
import com.example.catalogandroarch.di.component.AppComponent
import com.example.catalogandroarch.di.component.DaggerAppComponent

/**
 * @author Munif
 * @since 22/10/26.
 */
class CatalogAndroArchApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}