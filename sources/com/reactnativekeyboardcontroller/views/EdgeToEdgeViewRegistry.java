package com.reactnativekeyboardcontroller.views;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EdgeToEdgeViewRegistry {
    public static final EdgeToEdgeViewRegistry INSTANCE = new EdgeToEdgeViewRegistry();
    private static WeakReference lastCreatedView;

    private EdgeToEdgeViewRegistry() {
    }

    public final void register(EdgeToEdgeReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        lastCreatedView = new WeakReference(view);
    }

    public final EdgeToEdgeReactViewGroup get() {
        WeakReference weakReference = lastCreatedView;
        if (weakReference != null) {
            return (EdgeToEdgeReactViewGroup) weakReference.get();
        }
        return null;
    }
}
