# Hybrid_Android_HTML5
This is a basic Login Page Only Hybrid Mobile App, that uses HTML5, CSS and JavsScript functionalities

The web component of the app is placed under asserts folder inside main package
Web component package consists of a css style sheet, a javascript file and a html5 file

In order to load our web application from our local assets we will utilize the WebView method loadUrl(String url) and we will also enable JavaScript in our WebView, which is disabled by default

# JavaScript to Kotlin communication
A method for injecting Kotlin objects into a WebView is the addJavascriptInterface method of the WebView. Due to its security risks, especially on devices running Android earlier than 4.2, we will be utilizing a slightly different technique in this tutorial. If you do decide to utilize this method for JavaScript to Kotlin communication, please ensure that you have reviewed all of the security risks and vulnerabilities before implementing.

In order to retrieve messages from our web application running in our WebView, we will override the JavaScript prompt mechanism by overriding the chrome client for our WebView. We will do this by setting a new client through setWebChromeClient()

In our custom WebChromeClient we will override the function for all JSPrompts sent from our JavaScript and for any that have a title equal to jsBridgeKey (define this string key in your Kotlin and JavaScript and make sure to obfuscate your code for added security) then it will be processed as a command for us to run in our Kotlin Code (any without this title will be treated as normal JSPrompts)

# Kotlin to JavaScript Communication

For the final aspect of our bridge we will enable communication from our Kotlin code to our JavaScript code running in our web application. This can be simply done by utilizing the same loadUrl call used to load the web application itself. In order to call a specific JavaScript function, we simply add the prefix “javascript:” to our loadUrl String argument in order to call a function instead of loading new web content.




