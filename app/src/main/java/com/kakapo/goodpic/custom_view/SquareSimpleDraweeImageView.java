package com.kakapo.goodpic.custom_view;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by mustafasevgi on 06/03/16.
 */
public class SquareSimpleDraweeImageView extends SimpleDraweeView {
    public SquareSimpleDraweeImageView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public SquareSimpleDraweeImageView(Context context) {
        super(context);
    }

    public SquareSimpleDraweeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareSimpleDraweeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SquareSimpleDraweeImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
