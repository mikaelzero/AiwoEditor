package net.mikael.aiworicheditor

/**
 *
 * @ProjectName:    cosmetology
 * @Package:        com.jingrui.cosmetology.peditorweb
 * @ClassName:      EditorConfig
 * @Description:
 * @Author:         MikaelZero
 * @CreateDate:     2020/3/31 1:47 PM
 * @UpdateUser:     更新者：
 * @UpdateDate:     2020/3/31 1:47 PM
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class EditorConfig private constructor(builder: Builder) {

    val htmlEditor: String?
    val titleHint: String?
    val contentHint: String?
    val baseUrl: String?
    val oldHtml: String?
    val oldTitle: String?

    init {
        this.htmlEditor = builder.htmlEditor
        this.titleHint = builder.titleHint
        this.contentHint = builder.contentHint
        this.baseUrl = builder.baseUrl
        this.oldHtml = builder.oldHtml
        this.oldTitle = builder.oldTitle
    }

    class Builder {
        var htmlEditor: String? = null
            private set
        var titleHint: String? = null
            private set
        var contentHint: String? = null
            private set
        var baseUrl: String? = null
            private set
        var oldHtml: String? = null
            private set
        var oldTitle: String? = null
            private set

        fun htmlEditor(htmlEditor: String) = apply { this.htmlEditor = htmlEditor }
        fun titleHint(titleHint: String) = apply { this.titleHint = titleHint }
        fun contentHint(contentHint: String) = apply { this.contentHint = contentHint }
        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl }
        fun oldHtml(oldHtml: String?) = apply { this.oldHtml = oldHtml }
        fun oldTitle(oldTitle: String?) = apply { this.oldTitle = oldTitle }
        fun build() = EditorConfig(this)
    }
}