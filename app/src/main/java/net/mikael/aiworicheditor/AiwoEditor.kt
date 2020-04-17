package net.mikael.aiworicheditor

import android.os.Build
import android.webkit.WebView

/**
 *
 * @ProjectName:    cosmetology
 * @Package:        net.mikael.aiworicheditor
 * @ClassName:      AiwoEditor
 * @Description:
 * @Author:         MikaelZero
 * @CreateDate:     2020/3/31 1:43 PM
 * @UpdateUser:     更新者：
 * @UpdateDate:     2020/3/31 1:43 PM
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class AiwoEditor {
    var webView: ArticleEditorWebView? = null
    var jsCallbackReceiver: JsCallbackReceiver? = null
    var editorConfig: EditorConfig? = null

    fun initialize(
        webView: ArticleEditorWebView,
        editorConfig: EditorConfig,
        listener: OnJsEditorStateChangedListener
    ) {
        this.webView = webView
        this.editorConfig = editorConfig

        jsCallbackReceiver = JsCallbackReceiver(listener)
        webView.addJavascriptInterface(jsCallbackReceiver, "nativeCallbackHandler")
        webView.loadDataWithBaseURL(
            editorConfig.baseUrl,
            editorConfig.htmlEditor,
            "text/html",
            "utf-8",
            ""
        )
        WebView.setWebContentsDebuggingEnabled(true)
    }

    fun load() {
        webView?.post {
            refreshVisibleViewportSize()
            webView?.execJavaScriptFromString("ZSSEditor.getField('zss_field_content').setMultiline('true');")
            webView?.execJavaScriptFromString(
                "ZSSEditor.getField('zss_field_content').setPlaceholderText('" +
                        Utils.escapeQuotes(editorConfig?.contentHint) + "');"
            )
            webView?.execJavaScriptFromString(
                "ZSSEditor.getField('zss_field_title').setPlaceholderText('" +
                        Utils.escapeQuotes(editorConfig?.titleHint) + "');"
            )
            if (!editorConfig?.oldTitle.isNullOrEmpty()) {
                webView?.execJavaScriptFromString(
                    "ZSSEditor.getField('zss_field_title').setHTML('" + Utils.escapeHtml(
                        editorConfig?.oldTitle
                    ) + "');"
                )
            }
            if (!editorConfig?.oldHtml.isNullOrEmpty()) {
                webView?.execJavaScriptFromString(
                    "ZSSEditor.getField('zss_field_content').setHTML('" + Utils.escapeHtml(
                        editorConfig?.oldHtml
                    ) + "');"
                )
            }
            focusContent()
        }

    }

    fun refreshVisibleViewportSize() {
        webView?.execJavaScriptFromString("ZSSEditor.refreshVisibleViewportSize();")
    }

    fun focusContent() {
        webView?.execJavaScriptFromString("ZSSEditor.getField('zss_field_content').focus();")
    }

    fun insertImage(url: String) {
        webView?.execJavaScriptFromString("ZSSEditor.insertImage('$url', '');")
    }

    fun bold() {
        webView?.execJavaScriptFromString("ZSSEditor.setBold();")
    }

    fun blockQuote() {
        webView?.execJavaScriptFromString("ZSSEditor.setBlockQuote();")
    }

    fun setJustifyLeft() {
        webView?.execJavaScriptFromString("ZSSEditor.setJustifyLeft();")
    }

    fun setJustifyCenter() {
        webView?.execJavaScriptFromString("ZSSEditor.setJustifyCenter();")
    }

    fun setJustifyRight() {
        webView?.execJavaScriptFromString("ZSSEditor.setJustifyRight();")
    }

    fun undo() {
        webView?.execJavaScriptFromString("ZSSEditor.undo();")
    }

    fun redo() {
        webView?.execJavaScriptFromString("ZSSEditor.redo();")
    }

    fun getTitle() {
        webView?.execJavaScriptFromString("ZSSEditor.getField('zss_field_title').getHTMLForCallback();")
    }

    fun getContent() {
        webView?.execJavaScriptFromString("ZSSEditor.getField('zss_field_content').getHTMLForCallback();")
    }

    fun getImages() {
        webView?.execJavaScriptFromString("ZSSEditor.getField('zss_field_content').getImagesForCallback();")
    }

    fun getEditorStatus() {
        webView?.execJavaScriptFromString("ZSSEditor.getField('zss_field_content').getEditorStatusForCallback();")
    }

//    fun setBlackTextHighlight(blackText:String){
//        webView?.execJavaScriptFromString("ZSSEditor.setBlackTextHighlight($blackText);")
//    }

    fun removeUnUseHtml() {
        webView?.execJavaScriptFromString("ZSSEditor.removeUnUseHtml();")
    }

    fun getAllHTML() {
        webView?.execJavaScriptFromString("ZSSEditor.getAllHTMLForCallback();")
    }


    fun destory() {
        jsCallbackReceiver?.removeListener()
        webView?.removeAllViews()
        webView?.clearHistory()
        webView?.clearCache(true)
        webView?.loadUrl("about:blank")
        webView?.freeMemory()
//        webView?.pauseTimers()
//        webView?.stopLoading()
//        webView?.destroy()
        webView = null
    }

}