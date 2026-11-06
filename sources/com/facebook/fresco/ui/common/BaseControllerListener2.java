package com.facebook.fresco.ui.common;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class BaseControllerListener2 implements ControllerListener2 {
    public static final Companion Companion = new Companion(null);
    private static final ControllerListener2 NO_OP_LISTENER = new BaseControllerListener2();

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String id, Throwable th, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(String id, Object obj) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String id, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
