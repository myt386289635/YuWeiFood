package com.example.dllo.yuweifood.local;

import android.support.v7.widget.RecyclerView;

/**
 * Created by dllo on 16/9/8.
 */
public abstract class OnVerticalScrollListener
        extends RecyclerView.OnScrollListener {

    @Override
    public final void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (!recyclerView.canScrollVertically(-1)) {
            onScrolledToTop();
        } else if (!recyclerView.canScrollVertically(1)) {
            onScrolledToBottom();
        } else if (dy < 0) {
            onScrolledUp();
        } else if (dy > 0) {
            onScrolledDown();
        }
    }

    public  void onScrolledUp() {}

    public abstract void onScrolledDown();

    public abstract void onScrolledToTop();

    public void onScrolledToBottom() {}
}
