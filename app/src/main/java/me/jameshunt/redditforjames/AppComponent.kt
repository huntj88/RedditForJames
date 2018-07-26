package me.jameshunt.redditforjames

import dagger.Component
import me.jameshunt.base.BaseAppComponent
import me.jameshunt.base.OkHttpModule
import javax.inject.Singleton

@Singleton
@Component(modules = [OkHttpModule::class])
interface AppComponent: BaseAppComponent {
    //see BaseAppComponent too

}