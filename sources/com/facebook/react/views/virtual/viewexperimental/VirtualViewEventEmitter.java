package com.facebook.react.views.virtual.viewexperimental;

import android.graphics.Rect;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.virtual.VirtualViewMode;
import com.facebook.react.views.virtual.VirtualViewModeChangeEmitter;
import com.facebook.react.views.virtual.VirtualViewModeChangeEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualViewEventEmitter implements VirtualViewModeChangeEmitter {
    private final EventDispatcher dispatcher;
    private final int surfaceId;
    private final int viewId;

    public VirtualViewEventEmitter(int i, int i2, EventDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.viewId = i;
        this.surfaceId = i2;
        this.dispatcher = dispatcher;
    }

    @Override // com.facebook.react.views.virtual.VirtualViewModeChangeEmitter
    public void emitModeChange(VirtualViewMode mode, Rect targetRect, Rect thresholdRect, boolean z) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        Intrinsics.checkNotNullParameter(thresholdRect, "thresholdRect");
        this.dispatcher.dispatchEvent(new VirtualViewModeChangeEvent(this.surfaceId, this.viewId, mode, targetRect, thresholdRect, z));
    }
}
