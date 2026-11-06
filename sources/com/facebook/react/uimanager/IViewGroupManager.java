package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface IViewGroupManager extends IViewManagerWithChildren {
    void addView(View view, View view2, int i);

    View getChildAt(View view, int i);

    int getChildCount(View view);

    void removeViewAt(View view, int i);

    default void removeAllViews(View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        UiThreadUtil.assertOnUiThread();
        int childCount = getChildCount(parent);
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                return;
            } else {
                removeViewAt(parent, childCount);
            }
        }
    }
}
