package me.jameshunt.template

import android.app.Application
import me.jameshunt.appbase.BaseApplication

class TemplateApplication: BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        this.appComponent = AppComponent.create()
    }
}

fun Application.appComponent(): AppComponent {
    return (this as BaseApplication).appComponent as AppComponent
}