package me.jameshunt.template

import dagger.Component
import me.jameshunt.base.ActivityScope
import me.jameshunt.base.BaseActivityComponent

@ActivityScope
@Component(modules = [], dependencies = [(AppComponent::class)])
interface ActivityComponent: BaseActivityComponent {

    companion object {
        fun create(appComponent: AppComponent): ActivityComponent = DaggerActivityComponent
                .builder()
                .appComponent(appComponent)
                .build()
    }

    fun inject(mainActivity: MainActivity)
}