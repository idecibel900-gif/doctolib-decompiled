package com.teleport.extensions;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewKt {
    public static final int[] screenLocation(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static final boolean isDetached(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return !view.isAttachedToWindow();
    }

    public static final boolean canReparentAttached(View view, ViewGroup source, ViewGroup target) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        return source != target && view.isAttachedToWindow() && target.isAttachedToWindow() && source.getRootView() == target.getRootView() && !view.hasFocus() && source.getLayoutTransition() == null && target.getLayoutTransition() == null;
    }

    public static final int findNextSiblingHostIndex(List list, ViewGroup host, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(host, "host");
        int size = list.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            int iIndexOfChild = host.indexOfChild((View) list.get(i2));
            if (iIndexOfChild >= 0) {
                return iIndexOfChild;
            }
        }
        return -1;
    }
}
