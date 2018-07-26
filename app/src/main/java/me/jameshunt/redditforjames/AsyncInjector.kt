package me.jameshunt.redditforjames

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class AsyncInjector(private val mainActivity: MainActivity) {

    fun inject(): Completable {
        return Completable
                .fromAction { this.mainActivity.activityComponent().inject(this.mainActivity) }
                .subscribeOn(Schedulers.computation())
                //.delay(1, TimeUnit.SECONDS) //to see splash screen. currently dependency graph initializes too fast
                .observeOn(AndroidSchedulers.mainThread())
    }
}