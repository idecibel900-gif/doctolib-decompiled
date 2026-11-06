package com.swmansion.rnscreens.gamma.helpers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.swmansion.rnscreens.ScreenStack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewFinder {
    public static final ViewFinder INSTANCE = new ViewFinder();

    private ViewFinder() {
    }

    public final ScrollView findScrollViewInFirstDescendantChain(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        while (view != null) {
            if (view instanceof ScrollView) {
                return (ScrollView) view;
            }
            if (!(view instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 0) {
                return null;
            }
            view = viewGroup.getChildAt(0);
        }
        return null;
    }

    public final ScreenStack findScreenStackInFirstDescendantChain(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        while (view != null) {
            if (view instanceof ScreenStack) {
                return (ScreenStack) view;
            }
            if (!(view instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 0) {
                return null;
            }
            view = viewGroup.getChildAt(0);
        }
        return null;
    }
}
