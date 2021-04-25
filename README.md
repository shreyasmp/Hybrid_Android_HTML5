# Hybrid_Android_HTML5
This is a basic Login Page Only Hybrid Mobile App, that uses HTML5, CSS and JavsScript functionalities

The web component of the app is placed under asserts folder inside main package
Web component package consists of a css style sheet, a javascript file and a html5 file

In order to load our web application from our local assets we will utilize the WebView method loadUrl(String url) and we will also enable JavaScript in our WebView, which is disabled by default

In order to retrieve messages from our web application running in our WebView, we will override the JavaScript prompt mechanism by overriding the chrome client for our WebView. We will do this by setting a new client through setWebChromeClient()

In our custom WebChromeClient we will override the function for all JSPrompts sent from our JavaScript and for any that have a title equal to jsBridgeKey (define this string key in your Java and JavaScript and make sure to obfuscate your code for added security) then it will be processed as a command for us to run in our Java Code (any without this title will be treated as normal JSPrompts)


