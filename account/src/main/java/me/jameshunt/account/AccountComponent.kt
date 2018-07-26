package me.jameshunt.account

import dagger.Component
import me.jameshunt.base.BaseActivityComponent
import javax.inject.Scope

@AccountScope
@Component(modules = [], dependencies = [(BaseActivityComponent::class)])
interface AccountComponent {

    fun inject(loginFragment: LoginFragment)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AccountScope