package io.gnovakovski.coronanews

import android.app.Application
import io.gnovakovski.coronanews.injection.component.DaggerApplicationComponent

class CustomApplication : Application() {

    val appComponent = DaggerApplicationComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}