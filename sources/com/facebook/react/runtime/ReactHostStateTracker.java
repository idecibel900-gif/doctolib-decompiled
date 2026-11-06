package com.facebook.react.runtime;

import com.facebook.common.logging.FLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactHostStateTracker {
    private static final Companion Companion = new Companion(null);
    private final int id;

    public ReactHostStateTracker(int i) {
        this.id = i;
    }

    public static /* synthetic */ void enterState$default(ReactHostStateTracker reactHostStateTracker, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        reactHostStateTracker.enterState(str, str2);
    }

    public final void enterState(String method, String str) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (str == null) {
            FLog.w("BridgelessReact", "ReactHost{%d}.%s", Integer.valueOf(this.id), method);
        } else {
            FLog.w("BridgelessReact", "ReactHost{%d}.%s: %s", Integer.valueOf(this.id), method, str);
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
