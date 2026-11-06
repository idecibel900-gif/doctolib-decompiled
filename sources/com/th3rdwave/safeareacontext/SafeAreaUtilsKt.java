package com.th3rdwave.safeareacontext;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SafeAreaUtilsKt {
    private static final EdgeInsets getRootWindowInsetsCompatR(View view) {
        Insets insets;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar())) == null) {
            return null;
        }
        return new EdgeInsets(insets.top, insets.right, insets.bottom, insets.left);
    }

    private static final EdgeInsets getRootWindowInsetsCompatM(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        return new EdgeInsets(rootWindowInsets.getSystemWindowInsetTop(), rootWindowInsets.getSystemWindowInsetRight(), Math.min(rootWindowInsets.getSystemWindowInsetBottom(), rootWindowInsets.getStableInsetBottom()), rootWindowInsets.getSystemWindowInsetLeft());
    }

    private static final EdgeInsets getRootWindowInsetsCompat(View view) {
        return Build.VERSION.SDK_INT >= 30 ? getRootWindowInsetsCompatR(view) : getRootWindowInsetsCompatM(view);
    }

    public static final EdgeInsets getSafeAreaInsets(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getHeight() == 0) {
            return null;
        }
        View rootView = view.getRootView();
        Intrinsics.checkNotNull(rootView);
        EdgeInsets rootWindowInsetsCompat = getRootWindowInsetsCompat(rootView);
        if (rootWindowInsetsCompat == null) {
            return null;
        }
        float width = rootView.getWidth();
        float height = rootView.getHeight();
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        return new EdgeInsets(Math.max(rootWindowInsetsCompat.getTop() - rect.top, 0.0f), Math.max(Math.min((rect.left + view.getWidth()) - width, 0.0f) + rootWindowInsetsCompat.getRight(), 0.0f), Math.max(Math.min((rect.top + view.getHeight()) - height, 0.0f) + rootWindowInsetsCompat.getBottom(), 0.0f), Math.max(rootWindowInsetsCompat.getLeft() - rect.left, 0.0f));
    }

    public static final Rect getFrame(ViewGroup rootView, View view) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getParent() == null) {
            return null;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getDrawingRect(rect);
        try {
            rootView.offsetDescendantRectToMyCoords(view, rect);
            return new Rect(rect.left, rect.top, view.getWidth(), view.getHeight());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
