package me.jameshunt.account

import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

class LoginDependency @Inject constructor(private val okHttpClient: OkHttpClient) {

    /**
     * this basically represents the whole data layer and any architecture/patterns, which can be injected into the fragment
     */

    fun doThing() {
        Timber.i("i have an instance of: $okHttpClient")
    }

}