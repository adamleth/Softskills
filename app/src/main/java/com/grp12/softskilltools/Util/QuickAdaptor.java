package com.grp12.softskilltools.Util;

import android.content.Context;

import java.util.List;

/**
 * Created by mathiaslarsen on 08/01/2017.
 */

public abstract class QuickAdaptor<T> extends BaseQuickAdaptor<T, BaseAdaptorHelper> {

    /**
     * Create a QuickAdapter.
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public QuickAdaptor(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * @param context     The context.   cvu
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public QuickAdaptor(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }
}
