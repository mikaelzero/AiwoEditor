package net.mikael.aiworicheditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

import javax.xml.transform.ErrorListener;


/**
 * A text editor WebView with support for JavaScript execution.
 */
public abstract class EditorWebViewAbstract extends WebView {
    public abstract void execJavaScriptFromString(String javaScript);

    public EditorWebViewAbstract(Context context, AttributeSet attrs) {
        super(context, attrs);
        configureWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void configureWebView() {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");

        this.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }


        });
    }

    @Override
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override
    public void setVisibility(int visibility) {
        notifyVisibilityChanged(visibility == View.VISIBLE);
        super.setVisibility(visibility);
    }

    /**
     * Handles events that should be triggered when the WebView is hidden or is shown to the user
     *
     * @param visible the new visibility status of the WebView
     */
    public void notifyVisibilityChanged(boolean visible) {
        if (!visible) {
            this.post(() -> execJavaScriptFromString("ZSSEditor.pauseAllVideos();"));
        }
    }

}
