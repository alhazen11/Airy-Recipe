package com.apps.airyrecipe.ui

import android.content.Context
import com.apps.airyrecipe.data.di.DataModule
import com.apps.airyrecipe.data.di.DataScope
import com.apps.airyrecipe.data.repository.RecipeRepository
import com.apps.airyrecipe.data.repository.RecipeRepositoryImpl
import com.apps.airyrecipe.data.services.NetworkServices
import com.apps.airyrecipe.di.dashboard.HomeScope

import dagger.Module
import dagger.Provides

@Module(includes = [DataModule::class])
class MainModule(private val applicationContext: Context) {
    @HomeScope @Provides
    fun provideRepository(@DataScope service: NetworkServices): RecipeRepository {
        return RecipeRepositoryImpl(service)
    }

    @Provides @HomeScope
    fun provideContext(): Context {
        return applicationContext
    }
}