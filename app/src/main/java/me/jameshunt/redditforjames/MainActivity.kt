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

        showSplashFragment()

        this.activityComponent = createActivityComponent()
        AsyncInjector(this)
                .inject()
                .subscribeBy(
                        onError = { Timber.e(it) },
                        onComplete = {
                            //stop showing splash screen, dependencies ready to go
                            showTestFragment()
                            Timber.i(okHttpClient.toString())
                        }
                )
    }

    private fun createActivityComponent() = DaggerActivityComponent
            .builder()
            .appComponent(application.appComponent())
            .build()

    private fun showSplashFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, SplashFragment(), SplashFragment::class.java.simpleName)
                .commit()
    }

    private fun showTestFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, TestFragment(), TestFragment::class.java.simpleName)
                .commit()
    }

    override fun cleanUp() {

    }
}

fun MainActivity.activityComponent(): ActivityComponent {
    return (this as BaseActivity).activityComponent as ActivityComponent
}