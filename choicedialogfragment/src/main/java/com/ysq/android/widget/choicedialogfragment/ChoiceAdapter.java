package com.ysq.android.widget.choicedialogfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysq on 16/8/8.
 */
public class ChoiceAdapter extends BaseAdapter {
    private List<ChoiceItem> mData;
    private Context mContext;

    public ChoiceAdapter(Context context, List<ChoiceItem> data) {
        mContext = context;
        mData = data;
        if (mData == null) {
            mData = new ArrayList<>();
        }
    }

    public void setData(List<ChoiceItem> data) {
        this.mData = data;
        if (mData == null) {
            mData = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.tvTitle = (TextView) view.findViewById(android.R.id.text1);
            view.setTag(holder);
        } else {
            view = convertView;
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tvTitle.setText(mData.get(position).getShowName());
        return view;
    }

    public class ViewHolder {
        TextView tvTitle;
    }
}
