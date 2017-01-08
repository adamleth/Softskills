package com.grp12.softskilltools.Util;

/**
 * Created by mathiaslarsen on 08/01/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;


public abstract class BaseQuickAdaptor <T, H extends BaseAdaptorHelper> extends RecyclerView.Adapter<BaseAdaptorHelper> implements View.OnClickListener {
    protected static final String TAG = BaseQuickAdaptor.class.getSimpleName();

    protected final Context context;

    protected final int layoutResId;

    protected List<T> data;

    protected boolean displayIndeterminateProgress = false;

    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * Create a QuickAdapter.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public BaseQuickAdaptor(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public BaseQuickAdaptor(Context context, int layoutResId, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : data;
        this.context = context;
        this.layoutResId = layoutResId;
    }

    public void addAll(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return this.data;
    }

    public void add(Object a) {
        this.data.add((T) a);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public T getItem(int position) {
        if (position >= data.size()) return null;
        return data.get(position);
    }

    @Override
    public BaseAdaptorHelper onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutResId, viewGroup, false);
        view.setOnClickListener(this);
        BaseAdaptorHelper vh = new BaseAdaptorHelper(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(BaseAdaptorHelper helper, int position) {
        helper.itemView.setTag(position);
        T item = getItem(position);
        convert((H) helper, item);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    protected abstract void convert(H helper, T item);

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}

