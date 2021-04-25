package com.shreyas.hybridlogin.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.JsPromptResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shreyas.hybridlogin.R
import com.shreyas.hybridlogin.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val INDEX_HTML_FILE = "file:///android_asset/www/index.html"
        private const val jsBridgeCallback =
            "javascript:Bridge.callBack({success:true, message:\"logged in\"})"
    }

    @VisibleForTesting
    internal lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initializeWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initializeWebView() {
        binding.webView.loadUrl(INDEX_HTML_FILE)
        val webViewSettings = binding.webView.settings
        webViewSettings.javaScriptEnabled = true
        binding.webView.webChromeClient = BridgeWebViewClient()
    }

    inner class BridgeWebViewClient : WebChromeClient() {
        private val bridgeKey = "bridge_key"

        override fun onJsPrompt(
            view: WebView,
            url: String,
            message: String,
            response: String,
            result: JsPromptResult
        ): Boolean {
            if (message == bridgeKey) {
                val commandJson: JSONObject?
                try {
                    commandJson = JSONObject(response)
                    processJSCommand(commandJson)
                } catch (exception: JSONException) {
                    Log.e(TAG, "Invalid JSON: ${exception.message}")
                    result.confirm()
                    return true
                }
                result.confirm()
                return true
            } else {
                return false
            }
        }

        private fun processJSCommand(commandJSONObject: JSONObject) {
            val jsCommand = commandJSONObject.getString("method")

            if ("login" == jsCommand) {
                val state = commandJSONObject.getInt("state")
                if (state == 0) {
                    this@MainActivity.runOnUiThread {
                        binding.progressbar.visibility = View.VISIBLE
                    }
                } else if (state == 1) {
                    this@MainActivity.runOnUiThread {
                        binding.progressbar.visibility = View.GONE
                        binding.webView.loadUrl(jsBridgeCallback)
                    }
                }
            }
        }
    }
}