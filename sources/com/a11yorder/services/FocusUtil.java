package com.a11yorder.services;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FocusUtil {
    public static void focus(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (viewGroup.isImportantForAccessibility()) {
                viewGroup.sendAccessibilityEvent(8);
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            if (childAt == null || !childAt.isImportantForAccessibility()) {
                return;
            }
            childAt.sendAccessibilityEvent(8);
            return;
        }
        viewGroup.sendAccessibilityEvent(8);
    }
}
