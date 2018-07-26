package me.jameshunt.redditforjames

import dagger.Component
import me.jameshunt.base.ActivityScope
import me.jameshunt.base.BaseActivityComponent

@ActivityScope
@Component(modules = [], dependencies = [(AppComponent::class)])
interface ActivityComponent: BaseActivityComponent {

    fun inject(mainActivity: MainActivity)
}