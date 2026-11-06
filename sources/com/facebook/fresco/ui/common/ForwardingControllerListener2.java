package com.facebook.fresco.ui.common;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ForwardingControllerListener2 extends BaseControllerListener2 {
    public static final Companion Companion = new Companion(null);
    private final List listeners = new ArrayList(2);

    public final synchronized void addListener(ControllerListener2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final synchronized void removeListener(ControllerListener2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String id, Throwable th, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    ((ControllerListener2) this.listeners.get(i)).onFailure(id, th, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InternalListener exception in ");
                    sb.append("onFailure");
                }
            } catch (IndexOutOfBoundsException unused2) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    ((ControllerListener2) this.listeners.get(i)).onFinalImageSet(id, obj, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InternalListener exception in ");
                    sb.append("onFinalImageSet");
                }
            } catch (IndexOutOfBoundsException unused2) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    ((ControllerListener2) this.listeners.get(i)).onIntermediateImageFailed(id);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InternalListener exception in ");
                    sb.append("onIntermediateImageFailed");
                }
            } catch (IndexOutOfBoundsException unused2) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(String id, Object obj) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    ((ControllerListener2) this.listeners.get(i)).onIntermediateImageSet(id, obj);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InternalListener exception in ");
                    sb.append("onIntermediateImageSet");
                }
            } catch (IndexOutOfBoundsException unused2) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String id, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    ((ControllerListener2) this.listeners.get(i)).onRelease(id, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InternalListener exception in ");
                    sb.append("onRelease");
                }
            } catch (IndexOutOfBoundsException unused2) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    ((ControllerListener2) this.listeners.get(i)).onSubmit(id, obj, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InternalListener exception in ");
                    sb.append("onSubmit");
                }
            } catch (IndexOutOfBoundsException unused2) {
                return;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
