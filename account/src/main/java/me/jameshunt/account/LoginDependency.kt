package me.jameshunt.account

import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

//this basically represents the whole data layer, which can be injected into the fragment
class LoginDependency @Inject constructor(private val okHttpClient: OkHttpClient) {

    fun doThing() {
        Timber.i("i have an instance of: $okHttpClient")
    }

}