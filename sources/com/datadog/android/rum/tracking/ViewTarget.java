package com.datadog.android.rum.tracking;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewTarget {
    private final WeakReference viewRef;

    public final Node getNode() {
        return null;
    }

    public ViewTarget(WeakReference viewRef, Node node) {
        Intrinsics.checkNotNullParameter(viewRef, "viewRef");
        this.viewRef = viewRef;
    }

    public /* synthetic */ ViewTarget(WeakReference weakReference, Node node, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new WeakReference(null) : weakReference, (i & 2) != 0 ? null : node);
    }

    public final WeakReference getViewRef() {
        return this.viewRef;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ViewTarget) && Intrinsics.areEqual(this.viewRef.get(), ((ViewTarget) obj).viewRef.get()) && Intrinsics.areEqual((Object) null, (Object) null);
    }

    public int hashCode() {
        Object obj = this.viewRef.get();
        return (obj != null ? obj.hashCode() : 0) * 31;
    }
}
