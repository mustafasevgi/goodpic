package com.kakapo.goodpic;

import com.kakapo.goodpic.activity.BaseActivity;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public class Tools {
    public static int getStatusBarHeight(BaseActivity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
