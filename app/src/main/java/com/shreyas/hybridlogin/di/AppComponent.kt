package com.shreyas.hybridlogin.di

import android.app.Application
import com.shreyas.hybridlogin.MainApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        HybridAppModule::class
    ]
)
interface AppComponent {

    fun inject(mainApplication: MainApplication)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}