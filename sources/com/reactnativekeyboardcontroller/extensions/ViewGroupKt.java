package com.reactnativekeyboardcontroller.extensions;

import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewGroupKt {
    public static final void removeSelf(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewParent parent = viewGroup.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.removeView(viewGroup);
    }
}
