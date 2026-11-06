package com.swmansion.rnscreens.ext;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ViewKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewExtKt {
    public static final ViewGroup parentAsViewGroup(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static final View recycle(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup viewGroupParentAsViewGroup = parentAsViewGroup(view);
        if (viewGroupParentAsViewGroup != null) {
            viewGroupParentAsViewGroup.endViewTransition(view);
            viewGroupParentAsViewGroup.removeView(view);
        }
        view.setVisibility(0);
        view.setTranslationY(0.0f);
        return view;
    }

    public static final Fragment findFragmentOrNull(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            return ViewKt.findFragment(view);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static final boolean isMeasured(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0 && !view.isLaidOut()) ? false : true;
    }
}
