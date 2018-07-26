package me.jameshunt.redditforjames

import android.app.Application
import me.jameshunt.appbase.BaseApplication

class RedditApplication: BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .build()
    }
}

fun Application.appComponent(): AppComponent {
    return (this as BaseApplication).appComponent as AppComponent
}