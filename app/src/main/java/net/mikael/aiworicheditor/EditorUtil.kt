package net.mikael.aiworicheditor

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View
import android.widget.LinearLayout

/**
 *
 * @ProjectName:    cosmetology
 * @Package:        com.jingrui.cosmetology.pcommunity.posteditor
 * @ClassName:      EditorUtil
 * @Description:
 * @Author:         MikaelZero
 * @CreateDate:     2020/4/4 1:07 PM
 * @UpdateUser:     更新者：
 * @UpdateDate:     2020/4/4 1:07 PM
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class EditorUtil {
    companion object {
        fun showToolBar(toolbarLayout: LinearLayout) {
            if (toolbarLayout.visibility == View.VISIBLE) {
                return
            }
            toolbarLayout.post {
                toolbarLayout.visibility = View.VISIBLE
                val end = toolbarLayout.measuredHeight.toFloat()
                val objectAnimator = ObjectAnimator.ofFloat(toolbarLayout, "translationY", end, 0f)
                objectAnimator.duration = 300
                objectAnimator.start()
            }
        }

        fun hideToolBar(toolbarLayout: LinearLayout) {
            if (toolbarLayout.visibility == View.GONE) {
                return
            }
            toolbarLayout.post {
                val end = toolbarLayout.measuredHeight.toFloat()
                val objectAnimator = ObjectAnimator.ofFloat(toolbarLayout, "translationY", 0f, end)
                objectAnimator.duration = 300
                objectAnimator.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        toolbarLayout.visibility = View.GONE
                    }
                })
                objectAnimator.start()
            }
        }
    }
}