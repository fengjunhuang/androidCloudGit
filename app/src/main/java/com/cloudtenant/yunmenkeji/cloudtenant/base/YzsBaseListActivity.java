//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cloudtenant.yunmenkeji.cloudtenant.base;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzs.yzsbaseactivitylib.R.id;
import java.util.ArrayList;
import java.util.List;

public abstract class YzsBaseListActivity<T> extends YzsBaseActivity {
    private static final String TAG = "YzsBaseListActivity";
    protected static final int LINEAR_LAYOUT_MANAGER = 0;
    protected static final int GRID_LAYOUT_MANAGER = 1;
    protected static final int STAGGERED_GRID_LAYOUT_MANAGER = 2;
    private int mListType = 0;
    private boolean mIsVertical = true;
    private int mSpanCount = 1;
    protected RecyclerView mRecyclerView;
    protected YzsBaseListActivity<T>.YzsListAdapter mAdapter;
    private int layoutResId = -1;

    public YzsBaseListActivity() {
    }

    protected void initView() {
        this.initItemLayout();
        this.mRecyclerView = (RecyclerView)this.findViewById(id.yzs_base_list);
        this.chooseListType(this.mListType, this.mIsVertical);
        if(-1 == this.layoutResId) {
            throw new RuntimeException("layoutResId is null!");
        } else {
            this.mAdapter = new YzsBaseListActivity.YzsListAdapter(this.layoutResId, new ArrayList());
            this.mRecyclerView.setAdapter(this.mAdapter);
        }
    }

    public void setLayoutResId(@LayoutRes int layoutResId) {
        this.layoutResId = layoutResId;
    }

    protected abstract void initItemLayout();

    protected void openLoadMoreSize(boolean loadMore) {
        this.mAdapter.loadMoreEnd(loadMore);
    }

    protected void setListType(int type, boolean isVertical) {
        this.mListType = type;
        this.mIsVertical = isVertical;
    }

    protected void setSpanCount(int spanCount) {
        if(spanCount > 0) {
            this.mSpanCount = spanCount;
        }

    }

    private void chooseListType(int listType, boolean isVertical) {
        switch(listType) {
            case 0:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(isVertical?1:0);
                this.mRecyclerView.setLayoutManager(linearLayoutManager);
                break;
            case 1:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, this.mSpanCount);
                gridLayoutManager.setOrientation(isVertical?1:0);
                this.mRecyclerView.setLayoutManager(gridLayoutManager);
                break;
            case 2:
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.mSpanCount, isVertical?1:0);
                this.mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
            default:
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                layoutManager.setOrientation(isVertical?1:0);
                this.mRecyclerView.setLayoutManager(layoutManager);
        }

    }

    protected abstract void MyHolder(BaseViewHolder var1, T var2);

    public class YzsListAdapter extends BaseQuickAdapter<T, BaseViewHolder> {
        public YzsListAdapter(int this$0, List<T> layoutResId) {
            super(this$0,layoutResId);
        }

        protected void convert(BaseViewHolder baseViewHolder, T t) {
            YzsBaseListActivity.this.MyHolder(baseViewHolder, t);
        }
    }
}
