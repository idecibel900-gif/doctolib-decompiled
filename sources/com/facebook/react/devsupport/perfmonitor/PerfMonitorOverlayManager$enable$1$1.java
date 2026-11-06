package com.facebook.react.devsupport.perfmonitor;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
/* synthetic */ class PerfMonitorOverlayManager$enable$1$1 extends FunctionReferenceImpl implements Function0 {
    PerfMonitorOverlayManager$enable$1$1(Object obj) {
        super(0, obj, PerfMonitorOverlayManager.class, "handleRecordingButtonPress", "handleRecordingButtonPress()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m3376invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3376invoke() {
        ((PerfMonitorOverlayManager) this.receiver).handleRecordingButtonPress();
    }
}
