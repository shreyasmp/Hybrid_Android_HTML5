package com.shreyas.hybridlogin.di

import com.google.common.truth.Truth.assertThat
import com.shreyas.hybridlogin.MainApplication
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before

import org.junit.Test
import java.time.Instant

class HybridAppModuleTest {

    private val mockApplication = mockk<MainApplication>()
    private lateinit var module: HybridAppModule

    @Before
    fun setUp() {
        module = FakeHybridAppModule()
    }

    @Test
    fun `test provide context returns application context`() {
        every { mockApplication.applicationContext } returns mockApplication

        val result = HybridAppModule.provideApplicationContext(mockApplication)

        assertThat(result).isEqualTo(mockApplication)
        verify { mockApplication.applicationContext }

        Instant.now()
    }

    class FakeHybridAppModule : HybridAppModule() {

    }
}