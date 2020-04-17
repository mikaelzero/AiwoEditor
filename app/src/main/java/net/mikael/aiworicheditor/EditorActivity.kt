package net.mikael.aiworicheditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_editor.*
import org.json.JSONObject

class EditorActivity : AppCompatActivity(), OnJsEditorStateChangedListener {
    var aiwoEditor: AiwoEditor? = null
    val toggleMap = hashMapOf<String, CheckImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val oldTitle = intent.getStringExtra("oldTitle")
        val oldContent = intent.getStringExtra("oldContent")
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        setContentView(R.layout.activity_editor)

        toggleMap["bold"] = boldIv
        toggleMap["blockquote"] = quoteIv
        toggleMap["justifyLeft"] = alignLeftIv
        toggleMap["justifyCenter"] = alignCenterIv
        toggleMap["justifyRight"] = alignRightIv

        val htmlEditor: String = Utils.getHtmlFromFile(this, "editor.html")
        val editorConfig = EditorConfig.Builder().baseUrl("file:///android_asset/")
            .htmlEditor(htmlEditor)
            .titleHint("标题（5-30个字）")
            .contentHint("开始您的创作吧(请输入80个字以上)")
            .oldTitle(oldTitle ?: "")
            .oldHtml(oldContent ?: "")
            .build()

        aiwoEditor = AiwoEditor()
        aiwoEditor?.initialize(editorWebView, editorConfig, this)


        uploadImageIv.setOnClickListener {
            aiwoEditor?.insertImage("https://cdn.nlark.com/yuque/0/2020/png/252337/1587091196083-assets/web-upload/62122ab5-986b-4662-be88-d3007a5e31c5.png")
        }
        boldIv.setOnClickListener { aiwoEditor?.bold() }
        quoteIv.setOnClickListener { aiwoEditor?.blockQuote() }
        undoIv.setOnClickListener { aiwoEditor?.undo() }
        redoIv.setOnClickListener { aiwoEditor?.redo() }
        alignLeftIv.setOnClickListener { aiwoEditor?.setJustifyLeft() }
        alignCenterIv.setOnClickListener { aiwoEditor?.setJustifyCenter() }
        alignRightIv.setOnClickListener { aiwoEditor?.setJustifyRight() }
    }

    override fun onLinkTapped(url: String?, title: String?) {
    }

    override fun onGetHtmlResponse(inputArgs: MutableMap<String, String>) {
        val functionId: String? = inputArgs["function"]
        if (functionId.isNullOrEmpty()) {
            return
        }

        when (functionId) {
            "getAllHTMLForCallback" -> {
                val title: String? = inputArgs["title"]
                val content: String? = inputArgs["content"]
                val images: String? = inputArgs["images"]
                val editorStatus: Int = (inputArgs["editorStatus"] ?: "0").toInt()
                Log.e("aiwo editor result", "title:$title content:$content ")
            }
        }
    }

    override fun onSelectionChanged(selectionArgs: MutableMap<String, String>?) {
    }

    override fun onMediaTapped(
        mediaId: String?,
        mediaType: MediaType?,
        meta: JSONObject?,
        uploadStatus: String?
    ) {
    }

    override fun onMediaReplaced(mediaId: String?) {
    }

    override fun onActionFinished() {
    }

    override fun onSelectionStyleChanged(selectionArgs: MutableMap<String, Boolean>) {
        for ((key, value) in selectionArgs.entries) {
            toggleMap[key]?.setCheck(value)
        }
    }

    override fun onVideoPressInfoRequested(videoId: String?) {
    }

    override fun onFocusIn(focusId: String?) {
        if (focusId == null) {
            return
        }
        runOnUiThread {
            when (focusId) {
                "zss_field_title" -> {
                    EditorUtil.hideToolBar(toolbarLayout)
                }
                "zss_field_content" -> {
                    EditorUtil.showToolBar(toolbarLayout)
                }
            }
        }
    }

    override fun onDomLoaded() {
        aiwoEditor?.load()
    }

    override fun onMediaRemoved(mediaId: String?) {
    }
}
