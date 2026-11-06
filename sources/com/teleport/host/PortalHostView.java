package com.teleport.host;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.teleport.common.ReparentableReactViewGroup;
import com.teleport.global.PortalRegistry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PortalHostView extends ReparentableReactViewGroup {
    private int batchBaseIndex;
    private boolean isInBatch;
    private String name;
    private Integer pendingCleanupViewId;

    public PortalHostView(Context context) {
        super(context);
    }

    public final void setName(String str) {
        if (Intrinsics.areEqual(this.name, str)) {
            return;
        }
        String str2 = this.name;
        if (str2 != null) {
            PortalRegistry.INSTANCE.unregisterHost(str2, getId());
        }
        this.name = str;
        if (str != null) {
            PortalRegistry.INSTANCE.registerHost(str, this);
        }
    }

    public final void cleanup(int i) {
        if (isAttachedToWindow()) {
            this.pendingCleanupViewId = Integer.valueOf(i);
        } else {
            cleanupNow(i);
        }
    }

    public final int nextInsertionIndexForChildAt(int i) {
        if (!this.isInBatch) {
            this.isInBatch = true;
            this.batchBaseIndex = getChildCount();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.teleport.host.PortalHostView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.isInBatch = false;
                }
            });
        }
        return Math.min(this.batchBaseIndex + i, getChildCount());
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.getParent() != null || !child.isAttachedToWindow()) {
            super.addView(child, i);
        } else {
            attachDetachedView(child, i);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        String str = this.name;
        if (str != null) {
            PortalRegistry.INSTANCE.notifyHostLayoutChanged(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Integer num = this.pendingCleanupViewId;
        if (num != null) {
            cleanupNow(num.intValue());
        }
    }

    private final void cleanupNow(int i) {
        String str = this.name;
        if (str != null) {
            PortalRegistry.INSTANCE.unregisterHost(str, i);
        }
        this.name = null;
        this.isInBatch = false;
        this.batchBaseIndex = 0;
        this.pendingCleanupViewId = null;
    }
}
