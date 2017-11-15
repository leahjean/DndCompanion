package edu.illinois.cs465.ddc;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.w3c.dom.Attr;


/**
 * ViewPager wrapper to allow for wrap content heights
 * Based on https://stackoverflow.com/questions/8394681/android-i-am-unable-to-have-viewpager-wrap-content
 */
public class WrapContentHeightViewPager extends ViewPager {
    /**
     * Use the constructor from the base class, ViewPager
     */
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    /**
     * Constructor to alllow for additional paramaters
     */
    public WrapContentHeightViewPager(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int viewPagerHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View currChild = getChildAt(i);
            currChild.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int childHeight = currChild.getHeight();
            if (childHeight > viewPagerHeight) {
                viewPagerHeight = childHeight;
            }
        }

        int newHeightMeasureSpec = heightMeasureSpec;
        if (viewPagerHeight != 0) {
            newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(viewPagerHeight, MeasureSpec.EXACTLY);
        }

        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
