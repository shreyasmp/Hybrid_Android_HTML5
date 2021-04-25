package com.shreyas.hybridlogin.di.modules

import com.shreyas.hybridlogin.di.annotations.ActivityScope
import com.shreyas.hybridlogin.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HybridAppViewModule {

    // Activities here
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}