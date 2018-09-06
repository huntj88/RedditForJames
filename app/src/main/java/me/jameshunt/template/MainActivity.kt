package me.jameshunt.template

import android.os.Bundle
import io.reactivex.rxkotlin.subscribeBy
import me.jameshunt.account.LoginFragment
import me.jameshunt.app.L10n
import me.jameshunt.appbase.BaseActivity
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var okHttpClient: OkHttpClient
    // see OkHttpModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        L10n.add_receipt_help

        L10n.my_recipe_box_move_recipe("blag","blah")

        Timber.i("test: ${L10n.app_name}")

        showSplashFragment()

        AsyncInjector.inject(this).subscribeBy(
                onError = { Timber.e(it) },
                onComplete = {
                    //stop showing splash screen, dependencies ready to go
                    showLoginFragment()
                    Timber.i(okHttpClient.toString())
                }
        )
    }

    private fun showSplashFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, SplashFragment(), SplashFragment::class.java.simpleName)
                .commit()
    }

    private fun showLoginFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment(), LoginFragment::class.java.simpleName)
                .commit()
    }

    override fun cleanUp() {

    }
}