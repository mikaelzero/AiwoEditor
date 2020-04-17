package net.mikael.aiworicheditor;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * @ProjectName: cosmetology
 * @Package: com.jingrui.cosmetology.pcommunity.posteditor
 * @ClassName: CheckImageView
 * @Description:
 * @Author: MikaelZero
 * @CreateDate: 2020/3/29 7:15 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/29 7:15 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class CheckImageView extends AppCompatImageView {
    private int checkColor = Color.parseColor("#5B59DF");
    private int unCheckColor = Color.parseColor("#1C1C1F");

    public CheckImageView(Context context) {
        super(context);
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    boolean isCheck = false;

    public void setCheck(boolean check) {
        isCheck = check;
        setColorFilter(check ? checkColor : unCheckColor);
    }

    public boolean isCheck() {
        return isCheck;
    }
}
