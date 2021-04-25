package com.shreyas.hybridlogin.view

import android.os.Looper
import android.view.View
import com.google.common.truth.Truth.assertThat
import com.shreyas.hybridlogin.R
import com.shreyas.hybridlogin.runner.HybridRobolectricTestRunner
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Shadows

@RunWith(HybridRobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().visible().get()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
    }

    @Test
    fun `activity is successfully created`() {
        assertThat(activity).isNotNull()
    }

    @Test
    fun `should have correct app name`() {
        assertThat(activity.resources.getString(R.string.app_name)).isEqualTo("Hybrid App")
    }

    @Test
    fun `test activity view components are visible`() {
        assertThat(activity.binding.hybridMainLayout.visibility).isEqualTo(View.VISIBLE)
        assertThat(activity.binding.mainToolbar.visibility).isEqualTo(View.VISIBLE)
        assertThat(activity.binding.webView.visibility).isEqualTo(View.VISIBLE)
        assertThat(activity.binding.progressbar.visibility).isEqualTo(View.GONE)
    }

    @After
    fun tearDown() {
        activity.finish()
    }
}