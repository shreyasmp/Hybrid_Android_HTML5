package com.shreyas.hybridlogin.di.modules

import androidx.lifecycle.ViewModelProvider
import com.shreyas.hybridlogin.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bind(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}