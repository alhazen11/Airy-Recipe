package com.apps.neuronthings.di.dashboard

import com.apps.airyrecipe.di.dashboard.HomeScope
import com.apps.airyrecipe.ui.MainModule
import com.apps.airyrecipe.ui.MainViewModelModule
import com.apps.airyrecipe.ui.home.MainActivity
import dagger.Component

@HomeScope
@Component(modules = [MainModule::class, MainViewModelModule::class])
interface HomeComponent {
    fun inject(activity: MainActivity)
}