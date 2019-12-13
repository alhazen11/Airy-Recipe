package com.apps.airyrecipe.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.airyrecipe.abstraction.utils.viewmodel.ViewModelFactory
import com.apps.airyrecipe.abstraction.utils.viewmodel.ViewModelKey
import com.apps.airyrecipe.di.dashboard.HomeScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @HomeScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @HomeScope
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: MainViewModel): ViewModel

}