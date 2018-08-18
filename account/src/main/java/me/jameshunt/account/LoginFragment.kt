package me.jameshunt.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.jameshunt.appbase.BaseFragment
import javax.inject.Inject

class LoginFragment: BaseFragment() {

    /**
     * this class is just a proof of concept showing how a feature module might be added
     */

    @Inject
    lateinit var loginDependency: LoginDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AccountComponent.create(this).inject(this)

        loginDependency.doThing()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return View(context)
    }
}