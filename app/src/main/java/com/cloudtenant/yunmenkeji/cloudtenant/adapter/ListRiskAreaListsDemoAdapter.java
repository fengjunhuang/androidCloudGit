package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.activity.MessageRoomActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.util.OnItemClickLitener;

import java.util.List;
import java.util.Map;

/**
 * author：lmx
 * date：2018/3/7
 * description：
 */

public class ListRiskAreaListsDemoAdapter extends BaseAdapter {
    private OnItemClickLitener mOnItemClickLitener;
    private Context mContext;
    //单行的布局
    private int mResource;
    //列表展现的数据
    private List<? extends Map<String, ?>> mData;
    //Map中的key
    private String[] mFrom;
    //view的id
    private int[] mTo;

    //点击变色
    private int selectedPosition = -1;// 选中的位置

    /**
     * 构造方法
     * @param context
     * @param data 列表展现的数据
     * @param resource 单行的布局
     * @param from Map中的key
     * @param to view的id
     */
    public ListRiskAreaListsDemoAdapter(Activity context, List<? extends Map<String, ?>> data,
                                        int resource, String[] from, int[] to){
        mContext = context;
        mData = data;
        mResource = resource;
        mFrom = from;
        mTo = to;
    }
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
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
    public long getItemId(int position){
        return position;
    }

    //点击变色
    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ListRiskAreaListsDemoAdapter.ViewHolder holder;
        if(convertView == null){
            //使用自定义的list_items作为Layout
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            //使用减少findView的次数
            holder = new ListRiskAreaListsDemoAdapter.ViewHolder();
            holder.tvAreaItem = ((TextView) convertView.findViewById(mTo[0]));
            holder.tvAreaNo =  convertView.findViewById(mTo[1]);

            //设置标记
            convertView.setTag(holder);
        }else{
            holder = (ListRiskAreaListsDemoAdapter.ViewHolder) convertView.getTag();
        }
        final View view=convertView;

        int iTag = 0;
        int flag=0;
        for (int i = 0; i < mData.size(); i++) {
            if (i==0){
                iTag=(Integer)mData.get(i).get(mFrom[1]);
            }else {
                int newInt=(Integer) mData.get(i).get(mFrom[1]);
                if( newInt > iTag){
                    flag=i;
                }
            }
        }

        //设置数据
        final Map<String, ?> dataSet = mData.get(position);
        if (dataSet == null) {
            return null;
        }
        //获取该行数据
        final Object tvAreaItem = dataSet.get(mFrom[0]);

        holder.tvAreaItem.setText(tvAreaItem.toString());
        if (position==flag) {
            holder.tvAreaNo.setVisibility(View.VISIBLE);
        }else {
            holder.tvAreaNo.setVisibility(View.INVISIBLE);
        }
        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            convertView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mOnItemClickLitener.onItemClick(view, position);
                }
            });

            convertView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    mOnItemClickLitener.onItemLongClick(view, position);
                    return false;
                }
            });
        }
        return view;
    }

    /**
     * ViewHolder类
     */
    static class ViewHolder {
        TextView tvAreaItem;//区域名
        ImageView tvAreaNo;//No
    }

}

