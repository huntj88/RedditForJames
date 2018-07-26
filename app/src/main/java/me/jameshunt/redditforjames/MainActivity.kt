package me.jameshunt.redditforjames

import android.os.Bundle
import me.jameshunt.appbase.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.activityComponent = createActivityComponent()
        activityComponent().inject(this)
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