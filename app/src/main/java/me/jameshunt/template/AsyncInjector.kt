package me.jameshunt.template

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AsyncInjector private constructor() {
    companion object {
        fun inject(mainActivity: MainActivity): Completable {
            return Completable
                    .fromAction { mainActivity.activityComponent().inject(mainActivity) }
                    .subscribeOn(Schedulers.computation())
                    //.delay(1, TimeUnit.SECONDS) //to see splash screen. currently dependency graph initializes too fast
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}