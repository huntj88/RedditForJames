package me.jameshunt.redditforjames

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AsyncInjector(private val mainActivity: MainActivity) {

    fun inject(): Completable {
        return Completable
                .fromAction { this.mainActivity.activityComponent().inject(this.mainActivity) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
    }
}