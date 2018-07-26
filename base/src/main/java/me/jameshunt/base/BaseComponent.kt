package me.jameshunt.base

import okhttp3.OkHttpClient
import javax.inject.Scope



interface BaseAppComponent: AppDependenciesEverywhere
interface BaseActivityComponent: AppDependenciesEverywhere, ActivityDependenciesEverywhere


interface AppDependenciesEverywhere {
    //these appScopedDependencies that need to be available everywhere
    fun getOkHttpClient(): OkHttpClient
}

interface ActivityDependenciesEverywhere {
    //these ActivityScopedDependencies that need to be available everywhere except as dependencies for @Singleton's
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope