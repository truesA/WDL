package com.wdl.jwdl.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wdl.jwdl.R;

import java.util.List;

/**
 * author：lhm on 2018/3/24 20:20
 * <p>
 * email：3186834196@qq.com
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private List<String> data;
    private MyViewHolder holder;
    private int layoutPosition;
    private OnRecyclerViewItemClickListener mOnItemClickListener;

    public CustomAdapter(Context Context, List<String> List) {
        this.context = Context;
        this.data = List;
    }

    public int getItemCount() {
        return data.size();
    }

    public long getItemId(int i) {
        return i;
    }


    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {
        myViewHolder.textView.setText((CharSequence) data.get(position));
        myViewHolder.itemView.setTag(data.get(position));
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutPosition=myViewHolder.getLayoutPosition();
                notifyDataSetChanged();
                mOnItemClickListener.onItemClick(v, (String) myViewHolder.itemView.getTag(), layoutPosition);

            }
        });
        if (position == layoutPosition) {
            myViewHolder.textView.setBackgroundResource(R.drawable.button_bg_mianred_c5);
            myViewHolder.textView.setTextColor(Color.WHITE);

        }else {
            myViewHolder.textView.setBackgroundResource(R.drawable.edit_wilter_c5);
            myViewHolder.textView.setTextColor(Color.BLACK);
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int Int) {
        holder = new MyViewHolder(View.inflate(context, R.layout.busines_adapter, null));
        return holder;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener OnRecyclerViewItemClickListener) {
        mOnItemClickListener = OnRecyclerViewItemClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public MyViewHolder(View View) {
            super(View);
            textView = ((TextView) View.findViewById(R.id.item_string));
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View View, String String, int Int);
    }
}