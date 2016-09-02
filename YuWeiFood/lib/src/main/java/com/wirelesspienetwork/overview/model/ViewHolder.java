package com.wirelesspienetwork.overview.model;

import android.util.SparseArray;
import android.view.View;

import com.wirelesspienetwork.overview.R;
import com.wirelesspienetwork.overview.views.OverviewCard;

public class ViewHolder<V extends View, Model extends Object>
{
    //SparseArray 是 Integer 到 Object 的一个映射，可以在某些场合替换HashMap<Integer,<E>>
    //括号里只设置 Object
    private SparseArray<View> views;

    public final V itemView;
    public Model model;

    private OverviewCard mContainer;

    private int mCurrentPosition = -1;
    private int mLastPosition = -1;

    public ViewHolder(V view)
    {
        this.itemView = view;
        views = new SparseArray<>();
    }

    public <T extends View> T getView(int id){
        T t = (T) views.get(id);
        if (t == null){
            t = (T) itemView.findViewById(id);
            views.put(id,t);
        }
        return t;
    }

    public void setPosition(int position) {
        mLastPosition = mCurrentPosition;
        mCurrentPosition = position;
    }

    public int getPosition() {
        return mCurrentPosition;
    }

    public int getLastPosition() {
        return mLastPosition;
    }

    public OverviewCard getContainer()
    {
        return mContainer;
    }

    protected void setContainer(OverviewCard container) {
        if (mContainer != null) {
            mContainer.setContent(null);
        }
        mContainer = container;
        if (mContainer != null && itemView != null) {
            mContainer.setContent(itemView);
        }
    }
}
