package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactClippingViewGroupHelper {
    public static final ReactClippingViewGroupHelper INSTANCE = new ReactClippingViewGroupHelper();
    private static final Rect helperRect = new Rect();

    private ReactClippingViewGroupHelper() {
    }

    public static final void calculateClippingRect(View view, Rect outputRect) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outputRect, "outputRect");
        ViewParent parent = view.getParent();
        if (parent == null) {
            outputRect.setEmpty();
            return;
        }
        if (parent instanceof ReactClippingViewGroup) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) parent;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                Rect rect = helperRect;
                reactClippingViewGroup.getClippingRect(rect);
                if (!rect.intersect(view.getLeft(), view.getTop() + ((int) view.getTranslationY()), view.getRight(), view.getBottom() + ((int) view.getTranslationY()))) {
                    outputRect.setEmpty();
                    return;
                }
                rect.offset(-view.getLeft(), -view.getTop());
                rect.offset(-((int) view.getTranslationX()), -((int) view.getTranslationY()));
                rect.offset(view.getScrollX(), view.getScrollY());
                outputRect.set(rect);
                return;
            }
        }
        view.getDrawingRect(outputRect);
    }
}
