package me.jameshunt.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.jameshunt.appbase.BaseActivity
import me.jameshunt.appbase.BaseFragment
import javax.inject.Inject

class LoginFragment: BaseFragment() {

    @Inject
    lateinit var loginDependency: LoginDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createAccountComponent().inject(this)

        loginDependency.doThing()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return View(context)
    }

    private fun createAccountComponent(): AccountComponent {
        // i want this to crash if ever null
        val activityComponent = (activity as BaseActivity?)!!.activityComponent
        return DaggerAccountComponent.builder().baseActivityComponent(activityComponent).build()
    }
}