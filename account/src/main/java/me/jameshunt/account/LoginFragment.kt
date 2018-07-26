package me.jameshunt.account

import android.os.Bundle
import me.jameshunt.appbase.BaseActivity
import me.jameshunt.appbase.BaseFragment

class LoginFragment: BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createAccountComponent().inject(this)
    }

    private fun createAccountComponent(): AccountComponent {
        // i want this to crash if ever null
        val activityComponent = (activity as BaseActivity?)!!.activityComponent
        return DaggerAccountComponent.builder().baseActivityComponent(activityComponent).build()
    }
}