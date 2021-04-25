package com.shreyas.hybridlogin.view

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms
import androidx.test.espresso.web.webdriver.DriverAtoms.findElement
import androidx.test.espresso.web.webdriver.DriverAtoms.webClick
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// More information on Web view JS testing through AndroidJUnit can be found here:
// https://developer.android.com/training/testing/espresso/web

@RunWith(AndroidJUnit4::class)
class MainActivityAndroidTest {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_web_view_interaction() {
        onWebView().forceJavascriptEnabled()
    }

    @Test
    fun test_login_functionality() {
        activityTestRule.scenario.moveToState(Lifecycle.State.RESUMED)

        // Find the webview to interact and get the handle on web form elements
        onWebView()
            .withElement(findElement(Locator.ID, "username-field"))
            .perform(webClick())
            .perform(DriverAtoms.webKeys("username"))

            .withElement(findElement(Locator.ID, "password-field"))
            .perform(webClick())
            .perform(DriverAtoms.webKeys("password"))

            .withElement(findElement(Locator.ID, "login-button"))
            .perform(webClick())
    }
}