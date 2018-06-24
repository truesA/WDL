package com.wdl.jwdl.commom;

/**
 * author：lhm on 2018/3/24 11:22
 * <p>
 * email：3186834196@qq.com
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wdl.jwdl.commom.callback.OnItemClickListener;
import com.wdl.jwdl.commom.callback.OnItemLongClickListener;

import java.util.List;

public abstract class CommonRecyclerViewAdapter<T> extends RecyclerView.Adapter<CommonViewHolder>
{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mData;
    protected LayoutInflater mInflater;
    private OnItemClickListener clickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public CommonRecyclerViewAdapter(Context context, int layoutId, List<T> data) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mData = data;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder viewHolder = CommonViewHolder.get(mContext, parent, mLayoutId, clickListener, onItemLongClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        convert(holder, mData.get(position), position);
    }

    public abstract void convert(CommonViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 更新数据源, 更新后只有新的数据源, 更新前的数据完全被清除
     *
     * @param data 新的数据集合
     */
    public void updateDataSource(List<T> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 刷新数据源, 新的数据源会添加到旧数据的尾部
     *
     * @param data 新的数据集合
     */
    public void refreshDataSource(List<T> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

}