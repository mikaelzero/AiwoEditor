package net.mikael.aiworicheditor

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet

class ArticleEditorWebView(context: Context?, attrs: AttributeSet?) : EditorWebViewAbstract(context, attrs) {
    @SuppressLint("NewApi")
    override fun execJavaScriptFromString(javaScript: String) {
        evaluateJavascript(javaScript, null)
    }

}