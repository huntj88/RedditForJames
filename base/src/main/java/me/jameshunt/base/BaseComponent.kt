package me.jameshunt.base

import okhttp3.OkHttpClient
import javax.inject.Scope



interface BaseAppComponent {
    fun getOkHttpClient(): OkHttpClient
}
interface BaseActivityComponent {
    fun getOkHttpClient(): OkHttpClient
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope