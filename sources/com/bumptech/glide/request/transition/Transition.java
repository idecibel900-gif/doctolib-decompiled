package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public interface Transition {

    public interface ViewAdapter {
        Drawable getCurrentDrawable();

        void setDrawable(Drawable drawable);
    }

    boolean transition(Object obj, ViewAdapter viewAdapter);
}
