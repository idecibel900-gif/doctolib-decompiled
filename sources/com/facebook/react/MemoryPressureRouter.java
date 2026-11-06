package com.facebook.react;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.MemoryPressureListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryPressureRouter implements ComponentCallbacks2 {
    private final CopyOnWriteArrayList listeners;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public MemoryPressureRouter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listeners = new CopyOnWriteArrayList();
        context.getApplicationContext().registerComponentCallbacks(this);
    }

    public final void destroy(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getApplicationContext().unregisterComponentCallbacks(this);
    }

    public final void addMemoryPressureListener(MemoryPressureListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.listeners.contains(listener)) {
            return;
        }
        this.listeners.add(listener);
    }

    public final void removeMemoryPressureListener(MemoryPressureListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        dispatchMemoryPressure(i);
    }

    private final void dispatchMemoryPressure(int i) {
        Iterator it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((MemoryPressureListener) it.next()).handleMemoryPressure(i);
        }
    }
}
