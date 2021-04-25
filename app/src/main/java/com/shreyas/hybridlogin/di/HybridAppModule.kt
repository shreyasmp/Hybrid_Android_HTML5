package com.shreyas.hybridlogin.di

import android.app.Application
import android.content.Context
import com.shreyas.hybridlogin.di.modules.HybridAppViewModule
import com.shreyas.hybridlogin.di.modules.ViewModelFactoryModule
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class,
        HybridAppViewModule::class
    ]
)
abstract class HybridAppModule {

    companion object {
        @Provides
        fun provideApplicationContext(application: Application): Context {
            return application.applicationContext
        }
    }
}