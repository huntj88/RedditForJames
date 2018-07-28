package me.jameshunt.template

import dagger.Component
import me.jameshunt.base.BaseAppComponent
import me.jameshunt.base.OkHttpModule
import javax.inject.Singleton

@Singleton
@Component(modules = [OkHttpModule::class])
interface AppComponent: BaseAppComponent {
    //see BaseAppComponent too

    companion object {
        fun create(): AppComponent = DaggerAppComponent
                .builder()
                .build()
    }
}