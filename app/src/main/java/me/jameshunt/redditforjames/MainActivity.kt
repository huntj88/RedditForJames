package me.jameshunt.redditforjames

import android.os.Bundle
import io.reactivex.rxkotlin.subscribeBy
import me.jameshunt.appbase.BaseActivity
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.activityComponent = createActivityComponent()
        AsyncInjector(this)
                .inject()
                .subscribeBy(
                        onError = { Timber.e(it) },
                        onComplete = {
                            //stop showing splash screen, dependencies ready to go
                            Timber.i(okHttpClient.toString())
                        }
                )
    }

    private fun createActivityComponent() = DaggerActivityComponent
            .builder()
            .appComponent(application.appComponent())
            .build()

    override fun cleanUp() {

    }
}

fun MainActivity.activityComponent(): ActivityComponent {
    return (this as BaseActivity).activityComponent as ActivityComponent
}