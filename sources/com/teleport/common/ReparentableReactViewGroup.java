package com.teleport.common;

import android.content.Context;
import android.view.View;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReparentableReactViewGroup extends ReactViewGroup {
    public ReparentableReactViewGroup(Context context) {
        super(context);
    }

    public final void detachForReparent$react_native_teleport_release(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.hasTransientState()) {
            childHasTransientStateChanged(child, false);
        }
        super.detachViewFromParent(child);
        onViewRemoved(child);
        invalidate();
    }

    protected final void attachDetachedView(View child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.attachViewToParent(child, i, child.getLayoutParams());
        onViewAdded(child);
        if (child.hasTransientState()) {
            childHasTransientStateChanged(child, true);
        }
        invalidate();
    }
}
