package me.jameshunt.base

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class OkHttpModule {

    /**
     * probably would not provide a raw OkHttp instance,
     * but was just showing how something in the base module
     * is available everywhere else.
     *
     * what i would normally do is write a library in
     * another module which handled all the networking
     * for a specific api, and then get instances of that.
     */

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

}