package androidx.activity;

import android.window.BackEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Api36Impl {
    public static final Api36Impl INSTANCE = new Api36Impl();

    private Api36Impl() {
    }

    public final long frameTimeMillis(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getFrameTimeMillis();
    }
}
